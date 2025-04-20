package org.example.program02;

import com.partha.program02.Money;
import com.partha.program02.WithdrawRequest;
import io.grpc.ClientInterceptor;
import io.grpc.Deadline;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeadlineTest4 extends AbstractInterceptorTest {

    @Override
    protected List<ClientInterceptor> getClientInterceptor() {
        return List.of(new DeadlineInterceptor2(Duration.ofSeconds(2)));
    }


    @Test
    public void asyncDeadlineTest() {
        var observer = ResponseObserver.<Money>create();
        var request = WithdrawRequest.newBuilder()
                .setAccountNumber(1)
                .setAmount(50)
                .build();

        this.stub.withDeadline(Deadline.after(10, TimeUnit.SECONDS))
                .withdraw(request, observer);
        observer.awaite();
    }
}
