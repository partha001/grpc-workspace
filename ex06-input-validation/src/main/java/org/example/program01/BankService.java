package org.example.program01;

import com.google.common.util.concurrent.Uninterruptibles;
import com.partha.program01.AccountBalance;
import com.partha.program01.BalanceCheckRequest;
import com.partha.program01.BankServiceGrpc;
import com.partha.program01.Money;
import com.partha.program01.WithdrawRequest;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

//    @Override
//    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
//
//        responseObserver.onError(Status.INVALID_ARGUMENT.asRuntimeException());
//        //responseObserver.onError(Status.INVALID_ARGUMENT.asException()); //there is not much difference of this with the above except that it should be used for checked exception
//
//        //we want to perform the below if the input validation is correct
//        var accountNumber = request.getAccountNumber();
//        var balance = AccountRepository.getBalance(accountNumber);
//        var accountBalance = AccountBalance.newBuilder()
//                .setAccountNumber(accountNumber)
//                .setBalance(balance)
//                .build();
//        responseObserver.onNext(accountBalance);
//        responseObserver.onCompleted();
//    }

    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        RequestValidator.validateAccount(request.getAccountNumber())
                .map(Status::asRuntimeException)
                .ifPresentOrElse(
                        responseObserver::onError,
                        () -> sendAccountBalance(request, responseObserver)
                );
    }


    private void sendAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        var accountNumber = request.getAccountNumber();
        var balance = AccountRepository.getBalance(accountNumber);
        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(balance)
                .build();
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }


//    @Override
//    public void withdraw(WithdrawRequest request, StreamObserver<Money> responseObserver) {
//        var accountNumber = request.getAccountNumber();
//        var requestAmount = request.getAmount();
//        var accountBalance = AccountRepository.getBalance(accountNumber);
//
//        if (requestAmount > accountBalance) {
//            responseObserver.onCompleted(); //this will be changed to proper error handling later
//            return;
//        }
//
//        for (int i = 0; i < (requestAmount / 10); i++) {
//            var money = com.partha.program01.Money.newBuilder().setAmount(10).build();
//            responseObserver.onNext(money);
//            logger.info("money sent {}", money);
//            AccountRepository.deductAmount(accountNumber, 10);
//            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
//        }
//        responseObserver.onCompleted();
//    }

    @Override
    public void withdraw(WithdrawRequest request, StreamObserver<Money> responseObserver) {
        //chaining multiple validator optionals with or condition.
        RequestValidator.validateAccount(request.getAccountNumber())
                .or(()-> RequestValidator.isAmountDivisibleBy10(request.getAmount()))
                .or(()-> RequestValidator.hasSufficientBalance(request.getAmount(), AccountRepository.getBalance(request.getAccountNumber())))
                .map(Status::asRuntimeException)
                .ifPresentOrElse(
                        responseObserver::onError,
                        ()-> sendMoney(request, responseObserver)
                );

    }


    private void sendMoney(WithdrawRequest request, StreamObserver<Money> responseObserver) {
        var accountNumber = request.getAccountNumber();
        var requestAmount = request.getAmount();
        var accountBalance = AccountRepository.getBalance(accountNumber);

        if (requestAmount > accountBalance) {
            responseObserver.onCompleted(); //this will be changed to proper error handling later
            return;
        }

        for (int i = 0; i < (requestAmount / 10); i++) {
            var money = com.partha.program01.Money.newBuilder().setAmount(10).build();
            responseObserver.onNext(money);
            logger.info("money sent {}", money);
            AccountRepository.deductAmount(accountNumber, 10);
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        }
        responseObserver.onCompleted();
    }

}



