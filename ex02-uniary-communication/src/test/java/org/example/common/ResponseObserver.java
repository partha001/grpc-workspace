package org.example.common;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * test utility
 * @param <T>
 */
public class ResponseObserver<T> implements StreamObserver {

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

    @Override
    public void onNext(Object o) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {

    }
}
