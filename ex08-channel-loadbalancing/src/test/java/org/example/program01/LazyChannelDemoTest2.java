package org.example.program01;

import com.google.common.util.concurrent.Uninterruptibles;
import com.partha.program01.BalanceCheckRequest;
import com.partha.program01.BankServiceGrpc;
import org.example.common.AbstractChannelTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 this is an extension from the previous test class. here we have uncommented the code making the request to the server and have also introduced a
 delay. note that initially it doesnt throw anny error and prints the line :: test execution started
 its only when the grpc-request is made , then the client tries to connect to server and create the channel.
 thus showing that the channel gets created lazily.

 in this case since the server is not up so the connection to the server is not established and hence the channel creation fails
 */
public class LazyChannelDemoTest2 extends AbstractChannelTest {

    private static final Logger log = LoggerFactory.getLogger(LazyChannelDemoTest2.class);
    private final GrpcServer grpcServer = GrpcServer.create(new BankService());
    private BankServiceGrpc.BankServiceBlockingStub bankBlockingStub;

    @BeforeAll
    public void setup(){
        //this.grpcServer.start();
        this.bankBlockingStub = BankServiceGrpc.newBlockingStub(channel);
    }

    @Test
    public void lazyChannelDemo(){
        log.info("test execution started");
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        Uninterruptibles .sleepUninterruptibly(5, TimeUnit.SECONDS);
        var response = this.bankBlockingStub.getAccountBalance(request);
        log.info("{}", response);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
    }
}
