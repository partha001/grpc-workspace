package org.example.program01.b_executors;

import com.partha.program01.Money;
import com.partha.program01.WithdrawRequest;
import org.example.common.ResponseObserver;
import org.example.program01.AbstractTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * client without additional executor configuration
 */
public class ExecutorCallOptions1 extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ExecutorCallOptions1.class);

    @Test
    public void executorDemo(){
        var observer = ResponseObserver.<Money>create();
        var request = WithdrawRequest.newBuilder()
                .setAccountNumber(1)
                .setAmount(30)
                .build();
        this.stub.withdraw(request, observer);
        observer.awaite();
    }
}
