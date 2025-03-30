package org.example.program03;

import com.partha.program03.Money;
import com.partha.program03.ValidationCode;
import com.partha.program03.WithdrawRequest;
import io.grpc.StatusRuntimeException;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ServerStreamingInputValidationTest extends AbstractTest {


    @ParameterizedTest
    @MethodSource("testdata")
    public void blockingInputValidationTestMultipleValidation(WithdrawRequest request,ValidationCode code){
        var ex = Assertions.assertThrows(StatusRuntimeException.class, ()->{
            var response = this.bankBlockingStub.withdraw(request).hasNext();
        });

        //Assertions.assertEquals(code, ex.getStatus().getCode());
        Assertions.assertEquals(code, getValidationCode(ex));
    }

    private Stream<Arguments> testdata(){
        return Stream.of(
              //Arguments.of(WithdrawRequest.newBuilder().setAccountNumber(11).setAmount(10).build(), Status.Code.INVALID_ARGUMENT),
                //Arguments.of(WithdrawRequest.newBuilder().setAccountNumber(1).setAmount(17).build(), Status.Code.INVALID_ARGUMENT),
                //Arguments.of(WithdrawRequest.newBuilder().setAccountNumber(1).setAmount(120).build(), Status.Code.FAILED_PRECONDITION)

                Arguments.of(WithdrawRequest.newBuilder().setAccountNumber(11).setAmount(10).build(), ValidationCode.INVALID_ACCOUNT),
                Arguments.of(WithdrawRequest.newBuilder().setAccountNumber(1).setAmount(17).build(), ValidationCode.INVALID_AMOUNT),
                Arguments.of(WithdrawRequest.newBuilder().setAccountNumber(1).setAmount(120).build(), ValidationCode.INSUFFICIENT_BALANCE)        );
    }



    //now lets do the testing for the async stub as show below

    @ParameterizedTest
    @MethodSource("testdata")
    public void asyncInputValidationTestMultipleValidation(WithdrawRequest request,ValidationCode code){
        var observer = ResponseObserver.<Money>create();
        this.bankStub.withdraw(request,observer);
        observer.await();

        Assertions.assertTrue(observer.getItems().isEmpty());
        Assertions.assertNotNull(observer.getThrowable());

        //Assertions.assertEquals(code, ((StatusRuntimeException)observer.getThrowable()).getStatus().getCode());
        Assertions.assertEquals(code, getValidationCode(observer.getThrowable()));
    }


}
