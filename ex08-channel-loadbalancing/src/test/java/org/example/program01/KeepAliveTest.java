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
 * this class is to show eager channel creation behavior . however this is only for the purpose of demo.
 * this is the standard-practice in the grpc world.
 * <p>
 * note: lazy creation of channel is the default behavior of rpc. i.e. the channel gets created on the first rpc-call made by the client.
 * however if there is a explicit requirement for eager initialization of channel then that can be done as shown below
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
//        var response = this.bankBlockingStub.getAccountBalance(request);
//        log.info("{}", response);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
    }


}
