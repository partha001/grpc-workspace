package org.example.program01;

import com.partha.program01.BankServiceGrpc;
import com.partha.program01.TransferServiceGrpc;
import org.example.common.AbstractChannelTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class AbstractTest extends AbstractChannelTest {

    private final GrpcServer grpcServer = GrpcServer.create(new BankService(), new TransferService());
    protected BankServiceGrpc.BankServiceBlockingStub bankingBlockingStub;
    protected BankServiceGrpc.BankServiceStub bankingStub;

    protected TransferServiceGrpc.TransferServiceStub transferStub;

    @BeforeAll
    public void setup(){
        this.grpcServer.start();
        this.bankingBlockingStub = BankServiceGrpc.newBlockingStub(channel);
        this.bankingStub = BankServiceGrpc.newStub(channel);
        this.transferStub = TransferServiceGrpc.newStub(channel);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
    }
}
