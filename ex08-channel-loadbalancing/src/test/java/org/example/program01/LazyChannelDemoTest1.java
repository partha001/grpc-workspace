package org.example.program01;

import com.partha.program01.BalanceCheckRequest;
import com.partha.program01.BankServiceGrpc;
import org.example.common.AbstractChannelTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this test is to show that the channel gets created lazily. note that show we have commented out server.start()
 * still it doesnt throw any error and this test class runs fine. however will the server stop .
 * if we uncomment the below line then it will throw error
 * //var response = this.bankBlockingStub.getAccountBalance(request);
 *
 * and this is quite resonable since we are asking for response when the server is not up and so it throws error.
 * thus its to show that the channel gets created lazily when the request is made.
 */
public class LazyChannelDemoTest1 extends AbstractChannelTest {

    private static final Logger log = LoggerFactory.getLogger(LazyChannelDemoTest1.class);
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
