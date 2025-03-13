package org.example.program03;

import com.google.common.util.concurrent.ListenableFuture;
import com.partha.program03.AccountBalance;
import com.partha.program03.BalanceCheckRequest;
import com.partha.program03.BankServiceGrpc;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;

/**
 * this is another type of stub which returns a listenable future. it is to be noted that
 * the call listenbleFuture.get() is a blocking call. and hence we get the below output:
 *
 */
public class GrpcClient3 {

    private static final Logger log = LoggerFactory.getLogger(GrpcClient3.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var channel = ManagedChannelBuilder.forAddress("localhost",6565)
                .usePlaintext()
                .build();

        var stub = BankServiceGrpc.newFutureStub(channel);


        ListenableFuture<AccountBalance> accountBalanceListenableFuture = stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(2).build());
        AccountBalance accountBalance = accountBalanceListenableFuture.get();
        log.info("{}", accountBalance);

        log.info("done");

        //Thread.sleep(Duration.ofSeconds(2));

    }
}
