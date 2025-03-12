package org.example.program03;

import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.partha.program03.BankServiceGrpc;
import com.partha.program03.BalanceCheckRequest;

/**
 * this is the client-application which consumes the bankService exposed by the GrpcServer
 */
public class GrpcClient {

    private static final Logger log = LoggerFactory.getLogger(GrpcClient.class);

    public static void main(String[] args) {
        var channel = ManagedChannelBuilder.forAddress("localhost",6565)
                .usePlaintext()
                .build();

        var stub = BankServiceGrpc.newBlockingStub(channel);
        var balance = stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(2).build());
        log.info("{}", balance);
    }
}
