package org.example.program03;

import com.partha.program03.GuessNumberGrpc;
import org.example.common.AbstractChannelTest;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GuessNumberTest extends AbstractChannelTest {

    private static final Logger log = LoggerFactory.getLogger(GuessNumberTest.class);
    private final GrpcServer server = GrpcServer.create(new GuessNumberService());
    private GuessNumberGrpc.GuessNumberStub stub;

    @BeforeAll
    public void setup(){
        this.server.start();
        this.stub = GuessNumberGrpc.newStub(channel);
    }

    //@Test
    @RepeatedTest(5)
    public void guessNumberDemo(){
        var responseObserver = new GuessResponseHandler();
        var requestObserver = this.stub.makeGuess(responseObserver);
        responseObserver.setRequestObserver(requestObserver);
        responseObserver.start();
        responseObserver.await();
        log.info("-----------------------------");

    }

    @AfterAll
    public void stop(){
        this.server.stop();
    }

}
