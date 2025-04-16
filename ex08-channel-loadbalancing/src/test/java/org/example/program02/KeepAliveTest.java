package org.example.program02;

import com.google.common.util.concurrent.Uninterruptibles;
import com.partha.program02.BalanceCheckRequest;
import com.partha.program02.BankServiceGrpc;
import org.example.common.AbstractChannelTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 this test client is to see how ping and go away works between the client and server when we
 we have set keepAliveTime and keepAliveTimeout on the server.
  */
public class KeepAliveTest extends AbstractChannelTest {

    private static final Logger log = LoggerFactory.getLogger(KeepAliveTest.class);
    private final GrpcServer grpcServer = GrpcServer.create(new BankService());
    private BankServiceGrpc.BankServiceBlockingStub bankBlockingStub;

    @BeforeAll
    public void setup(){
        this.grpcServer.start();
        this.bankBlockingStub = BankServiceGrpc.newBlockingStub(channel);
    }

    @Test
    public void lazyChannelDemo(){
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        var response = this.bankBlockingStub.getAccountBalance(request);
        log.info("{}", response);

        //just blocking the thread for 30 seconds
        Uninterruptibles.sleepUninterruptibly(30, TimeUnit.SECONDS);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
    }


}
