package org.example.program01;

import com.partha.program01.AccountBalance;
import com.partha.program01.DepositRequest;
import com.partha.program01.Money;
import org.example.common.ResponseObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class Ex04Program01ClientStreamingIntegrationTestCase extends AbstractTest{

    @Test
    public void depositTest(){
        var responseObserver = ResponseObserver.<AccountBalance>create();
        var requestObserver = this.stub.deposit(responseObserver); //this works as the invoke call that we did via postman with empty message body

        //initial message - account number
        requestObserver.onNext(DepositRequest.newBuilder().setAccountNumber(5).build());

        //sending stream of money
        IntStream.rangeClosed(1,10)
                .mapToObj(i -> Money.newBuilder().setAmount(10).build())
                .map(m-> DepositRequest.newBuilder().setMoney(m).build())
                .forEach(requestObserver::onNext);

        //notifying the server that we are done
        requestObserver.onCompleted();

        //at this point the response-observer will recieve a response
        responseObserver.awaite();
        Assertions.assertEquals( 1, responseObserver.getItems().size());
        Assertions.assertEquals(200, responseObserver.getItems().getFirst().getBalance());
        Assertions.assertNull(responseObserver.getThrowable());
    }
}
