package org.example.program01;

import com.partha.program01.Money;
import com.partha.program01.WithdrawRequest;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ex03Program01ServerStreamingIntegrationTest extends AbstractTest{

    private static final Logger log = LoggerFactory.getLogger(Ex03Program01ServerStreamingIntegrationTest.class);

    @Test
    public void blockingClientWithdrawTest(){
        var request = WithdrawRequest.newBuilder()
                .setAccountNumber(2)
                .setAmount(20)
                .build();
        var iterator = this.bankingBlockingStub.withdraw(request);
        int count = 0;
        while(iterator.hasNext()){
            log.info("received money: {}", iterator.next());
            count++;
        }
        Assertions.assertEquals(2,count);
        //we can also add some more assertions if required
    }

    @Test
    public void asyncClientWithdrawTest(){
        var request = WithdrawRequest.newBuilder()
                .setAccountNumber(2)
                .setAmount(20)
                .build();
        var iterator = this.bankingBlockingStub.withdraw(request);
        int count = 0;


        var observer = ResponseObserver.<Money>create();
        this.bankingStub.withdraw(request,observer);
        observer.awaite();
        Assertions.assertEquals(2, observer.getItems().size());
        Assertions.assertEquals(10, observer.getItems().getFirst().getAmount());
        Assertions.assertNull(observer.getThrowable());
    }

}