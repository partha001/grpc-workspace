package org.example.program05;

import com.partha.program05.*;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractInterceptorTest {

    //private final org.example.program03.GrpcServer grpcServer = org.example.program03.GrpcServer.create(new BankService());

    /*  this is one way of doing it. */
    //    private final GrpcServer grpcServer = GrpcServer.create(6565, serverBuilder -> {
    //        serverBuilder.addService(new BankService())
    //                .intercept(new GzipResponseInterceptor());
    //    });

    /* however we want to make it dynamica and the server-interceptors from the testcase that we want to run */
    private GrpcServer grpcServer;

    protected BankServiceGrpc.BankServiceBlockingStub blockingStub;
    protected BankServiceGrpc.BankServiceStub stub;

    private ManagedChannel channel;

    protected abstract List<ClientInterceptor> getClientInterceptor();

    protected GrpcServer createServer(){
        return GrpcServer.create(6565, serverBuilder ->{
            serverBuilder.addService(new BankService())
                    .intercept(new GzipResponseInterceptor());
        });
    }

    @BeforeAll
    public void setup() {
        this.grpcServer = createServer();
        this.grpcServer.start();
        this.channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().intercept(getClientInterceptor()).build();
        this.blockingStub = BankServiceGrpc.newBlockingStub(channel);
        this.stub = BankServiceGrpc.newStub(channel);
    }

    @AfterAll
    public void stop() {
        this.grpcServer.stop();
        this.channel.shutdownNow();
    }
}
