package org.example.common;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * test utility
 * @param <T>
 */
public class ResponseObserver<T> implements StreamObserver<T> {

    private static final Logger log = LoggerFactory.getLogger(ResponseObserver.class);
    private final List<T> list = Collections.synchronizedList(new ArrayList<>());
    private final CountDownLatch latch;
    private Throwable throwable;

    public ResponseObserver(int countDown) {
        this.latch = new CountDownLatch(countDown);
    }

    public static <T> ResponseObserver<T> create(){
        return new ResponseObserver<>(1);
    }

    public static <T> ResponseObserver<T> create(int countdown){
        return new ResponseObserver<>(countdown);
    }

    @Override
    public void onNext(T t) {
        log.info("received item:{}",t );
        this.list.add(t);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("receiveed error",throwable);
        this.throwable = throwable;
        latch.countDown();
    }

    @Override
    public void onCompleted() {
        log.info("completed");
        this.latch.countDown();
    }

    public void await(){
        try{
            this.latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> getItems(){
        return this.list;
    }

    public Throwable getThrowable(){
        return throwable;
    }
}
