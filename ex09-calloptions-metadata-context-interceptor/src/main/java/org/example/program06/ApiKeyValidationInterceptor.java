package org.example.program06;

import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ApiKeyValidationInterceptor implements ServerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ApiKeyValidationInterceptor.class);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {

        log.info("{}", serverCall.getMethodDescriptor().getFullMethodName()); //explore the attribute available on the serverCall object.

        var apiKey = metadata.get(Constants.API_KEY);
        if(isValid(apiKey)){
            return serverCallHandler.startCall(serverCall, metadata); // if valid then allowing the call to go through
        }

        //if api key not valid then sending out appropriate message
        serverCall.close(
                Status.UNAUTHENTICATED.withDescription("client must provide valid api key"),
                metadata
        );

        return new ServerCall.Listener<ReqT>() {
        };
    }

    private boolean isValid(String apiKey){
        return Objects.nonNull(apiKey) && apiKey.equals("bank-client-secret");
    }
}
