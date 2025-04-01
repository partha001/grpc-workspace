package org.example.program01;

import com.partha.program01.AccountBalance;
import com.partha.program01.BalanceCheckRequest;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankingServiceAsyncClientIntegrationTest2 extends AbstractTest{

    private static final Logger log = LoggerFactory.getLogger(BankingServiceAsyncClientIntegrationTest2.class);

    @Test
    public void getAccountBalanceTest() {
        var request = BalanceCheckRequest.newBuilder().setAccountNumber(1).build();
        var observer = ResponseObserver.<AccountBalance>create();
        this.stub.getAccountBalance(request,observer );
        observer.awaite();
        Assertions.assertEquals(1, observer.getItems().size());
        Assertions.assertEquals(100, observer.getItems().getFirst().getBalance());
        //Assertions.assertEquals(99, observer.getItems().getFirst().getBalance());
        Assertions.assertNull(observer.getThrowable());
    }

}
