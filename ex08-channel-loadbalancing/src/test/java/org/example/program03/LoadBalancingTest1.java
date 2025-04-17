package org.example.program03;

import com.partha.program03.BalanceCheckRequest;
import com.partha.program03.BankServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoadBalancingTest1 {

    private static final Logger log = LoggerFactory.getLogger(LoadBalancingTest1.class);
    private BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub;
    private ManagedChannel channel;

    @BeforeAll
    public void setup(){
        /** note that the channel talks to the proxy service**/
        this.channel = ManagedChannelBuilder.forAddress("localhost",8585)
                .usePlaintext()
                .build();
        this.bankServiceBlockingStub = BankServiceGrpc.newBlockingStub(channel);
    }

    @Test
    public void loadBalancingDemo(){
        for(int i=1;i<=10;i++){
            var request  = BalanceCheckRequest.newBuilder()
                    .setAccountNumber(i)
                    .build();
            var response = this.bankServiceBlockingStub.getAccountBalance(request);
            log.info("{}", response);
        }
    }

    @AfterAll
    public void stop(){
        this.channel.shutdownNow();
    }

}
