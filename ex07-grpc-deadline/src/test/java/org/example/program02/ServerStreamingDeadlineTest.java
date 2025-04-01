package org.example.program02;

import com.google.common.util.concurrent.Uninterruptibles;
import com.partha.program02.Money;
import com.partha.program02.WithdrawRequest;
import io.grpc.Deadline;
import io.grpc.Status;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ServerStreamingDeadlineTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ServerStreamingDeadlineTest.class);


    @Test
    public void behavior2(){

        try{
            var request = WithdrawRequest.newBuilder()
                    .setAccountNumber(1)
                    .setAmount(50)
                    .build();

            var iterator = this.blockingStub
                    .withDeadline(Deadline.after(2, TimeUnit.SECONDS))
                    .withdraw(request);

            while(iterator.hasNext()){
                log.info("{}", iterator.next());
            }
        }catch (Exception e){
            log.info("error");
        }

        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
    }


    //writing test-case for the async-client
    @Test
    public void asyncDeadlineTest(){
        var observer = ResponseObserver.<Money>create();
        var request = WithdrawRequest.newBuilder()
                .setAccountNumber(1)
                .setAmount(50)
                .build();

        this.stub.withDeadline(Deadline.after(2, TimeUnit.SECONDS))
                .withdraw(request, observer);
        observer.awaite();
        Assertions.assertEquals(2, observer.getItems().size());
        Assertions.assertEquals(Status.Code.DEADLINE_EXCEEDED,Status.fromThrowable(observer.getThrowable()).getCode());
    }


}
