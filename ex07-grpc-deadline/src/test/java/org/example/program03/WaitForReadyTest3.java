package org.example.program03;

import com.partha.program03.BankServiceGrpc;
import com.partha.program03.WithdrawRequest;
import org.example.common.AbstractChannelTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitForReadyTest3 extends AbstractChannelTest {

    private static final Logger log = LoggerFactory.getLogger(WaitForReadyTest3.class);
    private final GrpcServer grpcServer = GrpcServer.create(new BankService());
    protected BankServiceGrpc.BankServiceBlockingStub blockingStub;


    @BeforeAll
    public void setup(){
        //this.grpcServer.start();
        this.blockingStub = BankServiceGrpc.newBlockingStub(channel);
        //this.stub = BankServiceGrpc.newStub(channel);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
    }


    @Test
    public void blockingDeadlineTest(){
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
