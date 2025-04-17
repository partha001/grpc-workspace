package org.example.program04;

import com.google.common.util.concurrent.Uninterruptibles;
import com.partha.program04.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoadBalancingTest2StreamingRequest {


    private static final Logger log = LoggerFactory.getLogger(LoadBalancingTest2StreamingRequest.class);
    private BankServiceGrpc.BankServiceStub bankServiceStub;
    private ManagedChannel channel;

    @BeforeAll
    public void setup(){
        /** note that the channel talks to the proxy service**/
        this.channel = ManagedChannelBuilder.forAddress("localhost",8585)
                .usePlaintext()
                .build();
        this.bankServiceStub = BankServiceGrpc.newStub(channel);
    }

    @Test
    public void depositTest(){
        var responseObserver = ResponseObserver.<AccountBalance>create();
        var requestObserver = this.bankServiceStub.deposit(responseObserver); //this works as the invoke call that we did via postman with empty message body

        //initial message - account number
        requestObserver.onNext(DepositRequest.newBuilder().setAccountNumber(5).build());

        //sending stream of money
        IntStream.rangeClosed(1,30)
                .mapToObj(i -> Money.newBuilder().setAmount(10).build())
                .map(m-> DepositRequest.newBuilder().setMoney(m).build())
                .forEach(d-> {
                    Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
                    requestObserver.onNext(d);
                });

        //notifying the server that we are done
        requestObserver.onCompleted();

        //at this point the response-observer will recieve a response
        responseObserver.awaite();
        Assertions.assertEquals( 1, responseObserver.getItems().size());
        Assertions.assertEquals(200, responseObserver.getItems().getFirst().getBalance());
        Assertions.assertNull(responseObserver.getThrowable());
    }

    @AfterAll
    public void stop(){
        this.channel.shutdownNow();
    }
}
