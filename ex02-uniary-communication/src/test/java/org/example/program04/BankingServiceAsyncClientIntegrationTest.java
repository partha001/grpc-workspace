package org.example.program04;

import com.partha.program04.AccountBalance;
import com.partha.program04.BalanceCheckRequest;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class BankingServiceAsyncClientIntegrationTest extends AbstractTest{

    private static final Logger log = LoggerFactory.getLogger(BankingServiceAsyncClientIntegrationTest.class);

    @Test
    public void getAccountBalanceTest() throws InterruptedException {
        var request = BalanceCheckRequest.newBuilder().setAccountNumber(1).build();
        var latch = new CountDownLatch(1);
        this.stub.getAccountBalance(request, new StreamObserver<AccountBalance>() {
            @Override
            public void onNext(AccountBalance accountBalance) {
                log.info("async balance received:{}", accountBalance);
                try {
                    Assertions.assertEquals( 100, accountBalance.getBalance());
                } finally {
                    latch.countDown();
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        });
        latch.await();
    }
}
