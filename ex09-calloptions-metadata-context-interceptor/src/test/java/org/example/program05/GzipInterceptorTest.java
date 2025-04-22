//package org.example.program05;
//
//import com.partha.program05.*;
//import io.grpc.ClientInterceptor;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//public class GzipInterceptorTest extends AbstractInterceptorTest {
//
//    @Override
//    protected List<ClientInterceptor> getClientInterceptor() {
//        return List.of(new GzipRequestInterceptor());
//    }
//
//    @Test
//    public void gzipDemo(){
//        var request = BalanceCheckRequest.newBuilder()
//                .setAccountNumber(1)
//                .build();
//        var response = this.blockingStub.getAccountBalance(request);
//    }
//}
