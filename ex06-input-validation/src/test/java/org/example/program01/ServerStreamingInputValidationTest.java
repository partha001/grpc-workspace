package org.example.program01;

import com.partha.program01.Money;
import com.partha.program01.WithdrawRequest;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ServerStreamingInputValidationTest extends AbstractTest {

//    /**
//     *  ideally this should work. however if we run the below test method it fails saying
//     *  org.opentest4j.AssertionFailedError: Expected io.grpc.StatusRuntimeException to be thrown, but nothing was thrown.
//     */
//    @Test
//    public void blockingInputValidationTest(){
//        var ex = Assertions.assertThrows(StatusRuntimeException.class, ()->{
//            var request = WithdrawRequest.newBuilder()
//                    .setAccountNumber(11)
//                    .setAmount(10)
//                    .build();
//            var response = this.bankBlockingStub.withdraw(request);
//        });
//        Assertions.assertEquals(Status.Code.INVALID_ARGUMENT, ex.getStatus().getCode());
//    }

    /**
     * the above code does work since since its a streaming response  and bankBlockingStub.withdraw(request) returns
     *  java. util. Iterator<Money> . thus we have to use the iterator method hasNext() to assert the exception
     */
    @Test
    public void blockingInputValidationTest(){
        var ex = Assertions.assertThrows(StatusRuntimeException.class, ()->{
            var request = WithdrawRequest.newBuilder()
                    .setAccountNumber(11)
                    .setAmount(10)
                    .build();
            var response = this.bankBlockingStub.withdraw(request).hasNext();
        });
        Assertions.assertEquals(Status.Code.INVALID_ARGUMENT, ex.getStatus().getCode());
    }


    /**
     * earlier we were testing only for one input and asserting for only one exception . however to assert for multiple inputs we
     * can make use of parameterized test as shown below
     */
    @ParameterizedTest
    @MethodSource("testdata")
    public void blockingInputValidationTestMultipleValidation(WithdrawRequest request,Status.Code code){
        var ex = Assertions.assertThrows(StatusRuntimeException.class, ()->{
            var response = this.bankBlockingStub.withdraw(request).hasNext();
        });
        Assertions.assertEquals(code, ex.getStatus().getCode());
    }

    private Stream<Arguments> testdata(){
        return Stream.of(
              Arguments.of(WithdrawRequest.newBuilder().setAccountNumber(11).setAmount(10).build(), Status.Code.INVALID_ARGUMENT),
                Arguments.of(WithdrawRequest.newBuilder().setAccountNumber(1).setAmount(17).build(), Status.Code.INVALID_ARGUMENT),
                Arguments.of(WithdrawRequest.newBuilder().setAccountNumber(1).setAmount(120).build(), Status.Code.FAILED_PRECONDITION)
        );
    }



    //now lets do the testing for the async stub as show below

    @ParameterizedTest
    @MethodSource("testdata")
    public void asyncInputValidationTestMultipleValidation(WithdrawRequest request,Status.Code code){
        var observer = ResponseObserver.<Money>create();
        this.bankStub.withdraw(request,observer);
        observer.await();

        Assertions.assertTrue(observer.getItems().isEmpty());
        Assertions.assertNotNull(observer.getThrowable());
        Assertions.assertEquals(code, ((StatusRuntimeException)observer.getThrowable()).getStatus().getCode());
    }


}
