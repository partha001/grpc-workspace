package org.example.program01;

import com.partha.program01.Money;
import com.partha.program01.WithdrawRequest;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;

/**
 * executing virtual thread per task executor. note that here i have used Executors.newVirtualThreadPerTaskExecutor()
 * however one choose to use any type of executor i.e. FixedThreadPoolExecutor, CachedThreadPoolExecutor, etc.
 */
public class ExecutorCallOptions2 extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ExecutorCallOptions2.class);

    @Test
    public void executorDemo() {
        var observer = ResponseObserver.<Money>create();
        var request = WithdrawRequest.newBuilder()
                .setAccountNumber(1)
                .setAmount(30)
                .build();
        this.stub
                .withExecutor(Executors.newVirtualThreadPerTaskExecutor())
                .withdraw(request, observer);
        observer.awaite();
    }
}
