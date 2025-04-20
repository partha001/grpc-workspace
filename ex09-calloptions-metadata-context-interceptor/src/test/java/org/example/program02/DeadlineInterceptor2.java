package org.example.program02;

import io.grpc.*;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DeadlineInterceptor2 implements ClientInterceptor {

    private final Duration duration;

    public DeadlineInterceptor2(Duration duration) {
        this.duration = duration;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
                                                               CallOptions callOptions,
                                                               Channel channel) {

        //callOptions = callOptions.withDeadline(Deadline.after(duration.toMillis(), TimeUnit.MILLISECONDS));

        //thus below we are using ternary operator to check if there is any deadline set by the client or not . if set then we are using the same.
        //else the interceptor adds its own default deadline
        callOptions = Objects.nonNull(callOptions.getDeadline())  ?
                callOptions :
                callOptions.withDeadline(Deadline.after(duration.toMillis(), TimeUnit.MILLISECONDS));

        return channel.newCall(methodDescriptor, callOptions);
    }
}
