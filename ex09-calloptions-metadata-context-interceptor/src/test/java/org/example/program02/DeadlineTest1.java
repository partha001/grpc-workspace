package org.example.program02;

import com.partha.program02.*;
import io.grpc.ClientInterceptor;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class DeadlineTest1 extends AbstractInterceptorTest {

    @Override
    protected List<ClientInterceptor> getClientInterceptor() {
        return Collections.EMPTY_LIST;
    }

    @Test
    public void blockingDeadlineTest() {
      var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();

        var response = this.blockingStub.getAccountBalance(request);
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
