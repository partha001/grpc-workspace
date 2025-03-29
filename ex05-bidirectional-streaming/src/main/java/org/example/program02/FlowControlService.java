package org.example.program02;

import com.partha.program02.FlowControlServiceGrpc;
import com.partha.program02.Output;
import com.partha.program02.RequestSize;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class FlowControlService extends FlowControlServiceGrpc.FlowControlServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(FlowControlService.class);

    @Override
    public StreamObserver<RequestSize> getMessage(StreamObserver<Output> responseObserver) {
        return new RequestHandler(responseObserver);
    }

    private static class RequestHandler implements StreamObserver<RequestSize>{


        private final StreamObserver<Output> responseObserver;
        private Integer emitted; //this is to keep a number of messages emitted so far

        public RequestHandler(StreamObserver<Output> response) {
            this.responseObserver = response;
            this.emitted =0;
        }

        @Override
        public void onNext(RequestSize requestSize) {
            IntStream.rangeClosed(emitted+1,100)
                    .limit(requestSize.getSize())
                    .forEach(i->{
                        log.info("emitting {}",i);
                        responseObserver.onNext(Output.newBuilder().setValue(i).build());
                    });
            emitted = emitted + requestSize.getSize();
            if(emitted>=100){
                responseObserver.onCompleted();
            }
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onCompleted() {
            this.responseObserver.onCompleted();
        }
    }
}
