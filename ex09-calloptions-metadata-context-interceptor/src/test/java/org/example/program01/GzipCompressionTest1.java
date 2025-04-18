package org.example.program01;

import com.partha.program01.*;
import org.example.common.AbstractChannelTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GzipCompressionTest1 extends AbstractChannelTest {

    private static final Logger log = LoggerFactory.getLogger(GzipCompressionTest1.class);
    private final GrpcServer grpcServer = GrpcServer.create(new BankService());
    private BankServiceGrpc.BankServiceBlockingStub bankBlockingStub;

    @BeforeAll
    public void setup(){
        //this.grpcServer.start();
        this.bankBlockingStub = BankServiceGrpc.newBlockingStub(channel);
    }

    @Test
    public void lazyChannelDemo(){
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
//        var response = this.bankBlockingStub.getAccountBalance(request);
//        log.info("{}", response);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
    }
}
