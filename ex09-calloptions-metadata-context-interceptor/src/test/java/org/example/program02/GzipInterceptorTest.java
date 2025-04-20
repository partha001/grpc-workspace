package org.example.program02;

import com.partha.program02.BalanceCheckRequest;
import io.grpc.ClientInterceptor;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GzipInterceptorTest extends AbstractInterceptorTest {

    @Override
    protected List<ClientInterceptor> getClientInterceptor() {
        return List.of(new GzipRequestInterceptor());
    }

    @Test
    public void gzipDemo(){
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        var response = this.blockingStub.getAccountBalance(request);
    }
}
