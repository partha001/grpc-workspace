package org.example.program03;

import com.partha.program03.BankServiceGrpc;
import com.partha.program03.WithdrawRequest;
import io.grpc.Deadline;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.example.common.AbstractChannelTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * this test client shows how the client-server interact without  WaitForReady
 */
public class WaitForReadyTest extends AbstractChannelTest {

    private static final Logger log = LoggerFactory.getLogger(WaitForReadyTest.class);
    private final GrpcServer grpcServer = GrpcServer.create(new BankService());
    protected BankServiceGrpc.BankServiceBlockingStub blockingStub;


    @BeforeAll
    public void setup(){
        this.grpcServer.start();
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
                    //.withDeadline(Deadline.after(2, TimeUnit.SECONDS))
                    .withdraw(request);
            while(iterator.hasNext()){
                log.info("{}", iterator.next()); //we do not care about the response
            }
    }

}
