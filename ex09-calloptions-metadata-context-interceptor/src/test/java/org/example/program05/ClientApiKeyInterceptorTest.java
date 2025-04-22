package org.example.program05;

import com.partha.program05.BalanceCheckRequest;
import io.grpc.ClientInterceptor;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClientApiKeyInterceptorTest extends  AbstractInterceptorTest{

    private static final Logger log = LoggerFactory.getLogger(ClientApiKeyInterceptorTest.class);
    private static final Metadata.Key<String> API_KEY = Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);


    @Override
    protected GrpcServer createServer(){
        return GrpcServer.create(6565, serverBuilder ->{
            serverBuilder.addService(new BankService())
                    .intercept(new ApiKeyValidationInterceptor());
        });
    }


    @Override
    protected List<ClientInterceptor> getClientInterceptor() {
        return List.of(MetadataUtils.newAttachHeadersInterceptor(getApiKey())); // thus we are using an out of the box interceptor
    }

    private Metadata getApiKey(){
        var metadata = new Metadata();

        /** comment and uncomment one of below line to verify if the server-interceptor is working properly or not **/
        metadata.put(API_KEY, "bank-client-secret"); //valid api key
        //metadata.put(API_KEY, "bank-client-secret-invalid"); //invalid api key

        return metadata;
    }


    @Test
    public void clientApiKeyDemo(){
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        var response = this.blockingStub.getAccountBalance(request);
        log.info("{}", response);
    }
}
