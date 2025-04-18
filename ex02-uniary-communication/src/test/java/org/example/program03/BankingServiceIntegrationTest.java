package org.example.program03;

import com.partha.program03.BalanceCheckRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankingServiceIntegrationTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(BankingServiceIntegrationTest.class);

    @Test
    public void getBalanceTest(){
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        var balance = this.blockingStub.getAccountBalance(request);
        log.info("unary balance recieved: {}", balance);
        Assertions.assertEquals(100, balance.getBalance());
    }

}
