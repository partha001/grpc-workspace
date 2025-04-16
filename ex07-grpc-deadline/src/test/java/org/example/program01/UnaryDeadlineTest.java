package org.example.program01;

import com.partha.program01.AccountBalance;
import com.partha.program01.BalanceCheckRequest;
import io.grpc.Deadline;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class UnaryDeadlineTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(UnaryDeadlineTest.class);

    /**
     * this method is not method for assertions but to play with the code.
     */
    @Test
    public void dummy() {
        //so a normal unary is call without using deadline looks as below
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        var response = this.blockingStub.getAccountBalance(request);
        log.info("{}", response);

        //however if we want to include deadline settings in the above call then it can be done as shown below
        try {
            response = this.blockingStub
                    .withDeadline(Deadline.after(2, TimeUnit.SECONDS))
                    .getAccountBalance(request);
            log.info("{}", response);
        } catch (Exception ex) {
            log.error("error occurred.", ex);
        }
    }

    @Test
    public void blockingDeadlineTest() {
        var ex = Assertions.assertThrows(StatusRuntimeException.class, () -> {
            var request = BalanceCheckRequest.newBuilder()
                    .setAccountNumber(1)
                    .build();

            var response = this.blockingStub
                    .withDeadline(Deadline.after(2, TimeUnit.SECONDS))
                    .getAccountBalance(request);
        });
        Assertions.assertEquals(Status.Code.DEADLINE_EXCEEDED, ex.getStatus().getCode());
    }


    @Test
    public void asyncDeadlineTest(){
        var observer = ResponseObserver.<AccountBalance>create();
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        this.stub.withDeadline(Deadline.after(2, TimeUnit.SECONDS))
                .getAccountBalance(request, observer);
        observer.awaite();
        Assertions.assertTrue(observer.getItems().isEmpty());
        Assertions.assertEquals(Status.Code.DEADLINE_EXCEEDED, ((StatusRuntimeException)observer.getThrowable()).getStatus().getCode());
        //there is a utility method fromThrowable() using which we can write the above code is a clearner way but it does the same as above behind the scene.
        Assertions.assertEquals(Status.Code.DEADLINE_EXCEEDED, Status.fromThrowable(observer.getThrowable()).getCode());

    }

}
