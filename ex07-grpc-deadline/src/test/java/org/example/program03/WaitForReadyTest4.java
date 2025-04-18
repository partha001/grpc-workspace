package org.example.program03;

import com.google.common.util.concurrent.Uninterruptibles;
import com.partha.program03.BankServiceGrpc;
import com.partha.program03.WithdrawRequest;
import org.example.common.AbstractChannelTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * this client-application with WaitForReady application shows that have made a client-request it waits for the server to
 * response since it has WaitForReady configure in it. here the server is not initally up when the request is made .
 * Rather here we have introduced a delay for the server to be up. and as soon as the server is up the client starts getting respone
 * and it completes normally.
 */
public class WaitForReadyTest4 extends AbstractChannelTest {

    private static final Logger log = LoggerFactory.getLogger(WaitForReadyTest4.class);
    private final GrpcServer grpcServer = GrpcServer.create(new BankService());
    protected BankServiceGrpc.BankServiceBlockingStub blockingStub;


    @BeforeAll
    public void setup(){
        //this.grpcServer.start();
        Runnable runnable = () -> {
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
            this.grpcServer.start();
        };
        Thread.ofVirtual().start(runnable);
        this.blockingStub = BankServiceGrpc.newBlockingStub(channel);
        //this.stub = BankServiceGrpc.newStub(channel);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
    }


    @Test
    public void blockingDeadlineTest(){
        log.info("sending request");
            var request = WithdrawRequest.newBuilder()
                    .setAccountNumber(1)
                    .setAmount(50)
                    .build();
            var iterator = this.blockingStub
                    .withWaitForReady()
                    //.withDeadline(Deadline.after(2, TimeUnit.SECONDS))
                    .withdraw(request);
            while(iterator.hasNext()){
                log.info("{}", iterator.next()); //we do not care about the response
            }
    }

}
