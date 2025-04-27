package org.example.program07;

import com.google.common.util.concurrent.Uninterruptibles;
import com.partha.program07.*;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 *  the below service implements the below logic. i.e. read the role from the context which has been set by the server-interceptor
 *  PRIME role => dont apply any deduction fee
 *  STANDARD role => apply 1 rupee deduction fee and then return the balance.
 *  the 3rd case ie. invalid token is already taken care by the server-interceptor before . so handling only these conditions is fine.
 */
public class UserRoleBankService extends BankServiceGrpc.BankServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(UserRoleBankService.class);

    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        var accountNumber = request.getAccountNumber();
        var balance = AccountRepository.getBalance(accountNumber);

        if(UserRole.STANDARD.equals(Constants.USER_ROLE_KEY.get())){
            var fee = balance > 0 ? 1: 0;
            AccountRepository.deductAmount(accountNumber, 1);
            balance = balance - fee;
        }

        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(balance)
                .build();

        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }


    @Override
    public void withdraw(WithdrawRequest request, StreamObserver<Money> responseObserver) {
       var accountNumber = request.getAccountNumber();
        var requestAmount = request.getAmount();
        var accountBalance = AccountRepository.getBalance(accountNumber);

        if(requestAmount>accountBalance){
            responseObserver.onError(Status.FAILED_PRECONDITION.asRuntimeException());
            return;
        }

        //Context.current().isCancelled() //using this we can easily understand if the client has cancelled the request or not
        //so now lets integrate this in our event-generation from the server

        //for(int i=0;i<(requestAmount/10);i++){
        for(int i=0;i<(requestAmount/10) && !Context.current().isCancelled();i++){
            var money = Money.newBuilder().setAmount(10).build();
            responseObserver.onNext(money);
            logger.info("money sent {}", money);
            AccountRepository.deductAmount(accountNumber,10);
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        }
        logger.info("streaming completed");
        responseObserver.onCompleted();
    }
}
