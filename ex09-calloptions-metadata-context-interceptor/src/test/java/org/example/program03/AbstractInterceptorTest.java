package org.example.program03;

import com.partha.program03.*;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.program03.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractInterceptorTest {

    private final GrpcServer grpcServer = GrpcServer.create(new BankService());
    protected BankServiceGrpc.BankServiceBlockingStub blockingStub;
    protected BankServiceGrpc.BankServiceStub stub;

    private ManagedChannel channel;
    protected abstract List<ClientInterceptor> getClientInterceptor();

    @BeforeAll
    public void setup(){
        this.grpcServer.start();
        this.channel = ManagedChannelBuilder.forAddress("localhost",6565)
                .usePlaintext()
                .intercept(getClientInterceptor())
                .build();
        this.blockingStub = BankServiceGrpc.newBlockingStub(channel);
        this.stub = BankServiceGrpc.newStub(channel);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
        this.channel.shutdownNow();
    }
}
