package org.example.program01;

import com.partha.program01.AccountBalance;
import com.partha.program01.BalanceCheckRequest;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnaryInputValidationTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(UnaryInputValidationTest.class);

    /**
     * first testing with blocking client
     */
    @Test
    public void blockingInputValidationTest() {
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(11)
                .build();

//        //optionally first we can use try-catch and logger to inspect the error that we are receiving.
//        try{
//            var response = this.bankBlockingStub.getAccountBalance(request);
//        }catch (StatusRuntimeException ex){
//            log.info("{}", ex.getStatus().getCode());
//        }

//        //and then once we have inspected the exception coming the invocation using the above code then
//        //we can write our assertions as shown below.
//        Assertions.assertThrows(StatusRuntimeException.class, ()-> {
//            var response = this.bankBlockingStub.getAccountBalance(request);
//        });

        //note that in the above assertion we are checking on the exception class. however if we want to assert the
        //exception code as well then that can be done as shown below
        var ex = Assertions.assertThrows(StatusRuntimeException.class, () -> {
            var response = this.bankBlockingStub.getAccountBalance(request);
        });
        Assertions.assertEquals(Status.Code.INVALID_ARGUMENT, ex.getStatus().getCode());
    }


    /**
     * now writing test-case for the aync client
     */
    @Test
    public void asyncInputValidationTest(){
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(11)
                .build();
        var observer = ResponseObserver.<AccountBalance>create();
        this.bankStub.getAccountBalance(request,observer);
        observer.await();

        Assertions.assertTrue(observer.getItems().isEmpty());
        Assertions.assertNotNull(observer.getThrowable());
        Assertions.assertEquals(Status.Code.INVALID_ARGUMENT, ((StatusRuntimeException)observer.getThrowable()).getStatus().getCode());
    }
}
