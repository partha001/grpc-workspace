package org.example.program01;

import com.google.common.util.concurrent.Uninterruptibles;
import com.partha.program01.WithdrawRequest;
import io.grpc.Deadline;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ServerStreamingDeadlineTest extends AbstractTest{

    private static final Logger log = LoggerFactory.getLogger(ServerStreamingDeadlineTest.class);

    /** there are 2 issues with deadline in case of server streaming **/


    /**
     * behavior1: if we mention deadline then the client expects to receive the onComplete signal from the server [i.e. the whole response]
     * within the specified deadline . though this is not exactly a problem
     */
    @Test
    public void behavior1(){

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

        //that is why after receiving 2 events [of 1second each] the client-says acts like it cant wait to receive any more event
        //so one has be careful if we are using deadline for long-running server-streaming jobs
    }


    /**
     * beharior2: here we put the same above code in a try-catch block. and also add a sleep to the consumer thread.
     * upon doing so we observe that though after 2 seconds the client gives a deadline error upon not receiving the onComplete within 2seconds
     * and  stops reading any furthur events . however the server is unaware of this and still keep emiting events event after 2 seconds
     */
    @Test
    public void beharior2(){

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


}
