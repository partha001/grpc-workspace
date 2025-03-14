package org.example.program04;

import com.partha.program04.AccountBalance;
import com.partha.program04.BalanceCheckRequest;
import com.partha.program04.BankServiceGrpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this this is a non-blocking or async-client. note that it makes the call and then exits without even waiting
 * for the request to arrive.
 *  output: done
 *
 * however if we uncomment the thread.sleep() then we see  the below output:
 * done
 * account_number: 2
 * balance: 100
 * completed
 */
public class GrpcClient2 {

    private static final Logger log = LoggerFactory.getLogger(GrpcClient2.class);

    public static void main(String[] args) throws InterruptedException {
        var channel = ManagedChannelBuilder.forAddress("localhost",6565)
                .usePlaintext()
                .build();

        var stub = BankServiceGrpc.newStub(channel);

        stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(2).build(), new StreamObserver<AccountBalance>() {
            @Override
            public void onNext(AccountBalance accountBalance) {
                log.info("{}", accountBalance);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                log.info("completed");
            }
        });

        log.info("done");
        //Thread.sleep(Duration.ofSeconds(2));

    }
}
