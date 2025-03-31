package org.example.program03;

import com.partha.program03.BankServiceGrpc;
import com.partha.program03.ErrorMessage;
import com.partha.program03.ValidationCode;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import org.example.common.AbstractChannelTest;
import org.example.program03.BankService;
import org.example.program03.GrpcServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import javax.swing.text.html.Option;
import java.util.Optional;

public class AbstractTest extends AbstractChannelTest {

    private final org.example.program03.GrpcServer grpcServer = GrpcServer.create(new BankService());
    protected BankServiceGrpc.BankServiceBlockingStub bankBlockingStub;
    protected BankServiceGrpc.BankServiceStub bankStub;

    //here are the new changes
    private static final Metadata.Key<ErrorMessage> ERROR_MESSAGE_KEY = ProtoUtils.keyForProto(ErrorMessage.getDefaultInstance());

    @BeforeAll
    public void setup(){
        this.grpcServer.start();
        this.bankBlockingStub = BankServiceGrpc.newBlockingStub(channel);
        this.bankStub = BankServiceGrpc.newStub(channel);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
    }

    //we are doing this for assertions
    protected ValidationCode getValidationCode(Throwable throwable){
        return Optional.ofNullable(Status.trailersFromThrowable(throwable))
                .map(m-> m.get(ERROR_MESSAGE_KEY))
                .map(ErrorMessage::getValidationCode)
                .orElseThrow();
    }
}
