package org.example.program02;

import com.partha.program02.BalanceCheckRequest;
import io.grpc.ClientInterceptor;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

public class DeadlineTest2 extends AbstractInterceptorTest {

    @Override
    protected List<ClientInterceptor> getClientInterceptor() {
        return List.of(new DeadlineInterceptor(Duration.ofSeconds(2)));
    }

    @Test
    public void blockingDeadlineTest() {
//        var ex = Assertions.assertThrows(StatusRuntimeException.class, () -> {
//            var request = BalanceCheckRequest.newBuilder()
//                    .setAccountNumber(1)
//                    .build();
//
//            var response = this.blockingStub
//                    //.withDeadline(Deadline.after(2, TimeUnit.SECONDS))
//                    .getAccountBalance(request);
//        });
//        Assertions.assertEquals(Status.Code.DEADLINE_EXCEEDED, ex.getStatus().getCode());
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();

        var response = this.blockingStub
                .getAccountBalance(request);
    }


//    //writing test-case for the async-client
//    @Test
//    public void asyncDeadlineTest(){
//        var observer = ResponseObserver.<Money>create();
//        var request = WithdrawRequest.newBuilder()
//                .setAccountNumber(1)
//                .setAmount(50)
//                .build();
//
//        this.stub.withDeadline(Deadline.after(2, TimeUnit.SECONDS))
//                .withdraw(request, observer);
//        observer.awaite();
//        Assertions.assertEquals(2, observer.getItems().size());
//        Assertions.assertEquals(Status.Code.DEADLINE_EXCEEDED,Status.fromThrowable(observer.getThrowable()).getCode());
//    }
}
