package org.example.program03;

import com.google.common.util.concurrent.Uninterruptibles;
import com.partha.program03.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(BankService.class);


    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        RequestValidator.validateAccount(request.getAccountNumber())
                //.map(Status::asRuntimeException)
                .ifPresentOrElse(
                        responseObserver::onError,
                        () -> sendAccountBalance(request, responseObserver)
                );
    }


    private void sendAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        var accountNumber = request.getAccountNumber();
        var balance = org.example.program02.AccountRepository.getBalance(accountNumber);
        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(balance)
                .build();
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }


    @Override
    public void withdraw(WithdrawRequest request, StreamObserver<Money> responseObserver) {
        //chaining multiple validator optionals with or condition.
        RequestValidator.validateAccount(request.getAccountNumber())
                .or(() -> RequestValidator.isAmountDivisibleBy10(request.getAmount()))
                .or(() -> RequestValidator.hasSufficientBalance(request.getAmount(), AccountRepository.getBalance(request.getAccountNumber())))
                //.map(Status::asRuntimeException)
                .ifPresentOrElse(
                        responseObserver::onError,
                        () -> sendMoney(request, responseObserver)
                );

    }


    private void sendMoney(WithdrawRequest request, StreamObserver<Money> responseObserver) {
        try {
            var accountNumber = request.getAccountNumber();
            var requestAmount = request.getAmount();

            for (int i = 0; i < (requestAmount / 10); i++) {
                var money = Money.newBuilder().setAmount(10).build();

                //this is to simulate a server-error when the incoming account-id is 3
                if (i == 2) {
                    throw new RuntimeException();
                }

                responseObserver.onNext(money);
                logger.info("money sent {}", money);
                AccountRepository.deductAmount(accountNumber, 10);
                Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
            }
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException()
            );
        }
    }

}



