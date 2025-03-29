package org.example.program03;

import com.partha.program03.GuessRequest;
import com.partha.program03.GuessResponse;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class GuessResponseHandler implements StreamObserver<GuessResponse> {

    private static final Logger log = LoggerFactory.getLogger(GuessResponseHandler.class);
    private final CountDownLatch latch = new CountDownLatch(1);
    private StreamObserver<GuessRequest> requestObserver;
    private int lower;
    private int upper;
    private int middle;

    @Override
    public void onNext(GuessResponse guessResponse) {
        log.info("attempt:{} result:{}", guessResponse.getAttempt(), guessResponse.getResult());
        switch (guessResponse.getResult()){
            case TOO_LOW ->  this.send(this.middle, this.upper);
            case TOO_HIGH -> this.send(this.lower, this.middle);
            //we can ignore the case of correct result as the game will be over
        }

    }

    @Override
    public void onError(Throwable throwable) {
        latch.countDown();
    }

    @Override
    public void onCompleted() {
        requestObserver.onCompleted();
        latch.countDown();

    }


    public void start(){
        this.send(0,100);
    }

    public void await(){
        try{
            latch.await();
        }catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }
    }

    private void send(int low, int high){
        this.lower = low;
        this.upper = high;
        this.middle = low + (high -low)/2;
        log.info("client guessed:{}",this.middle);
        this.requestObserver.onNext(GuessRequest.newBuilder().setGuess(this.middle).build());
    }

    public void setRequestObserver(StreamObserver<GuessRequest> requestObserver){
        this.requestObserver = requestObserver;
    }
}
