package org.example.program02;

import com.google.common.util.concurrent.Uninterruptibles;
import com.partha.program02.*;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        var accountNumber = request.getAccountNumber();
        var balance = AccountRepository.getBalance(accountNumber);
        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(balance)
                .build();

        //adding a delay here to test deadline
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        //to enable compression on the server-side at a service level just uncomment the below line.
        ((ServerCallStreamObserver<AccountBalance>)responseObserver).setCompression("gzip");

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
