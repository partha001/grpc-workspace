package org.example.program07;

import com.partha.program07.BalanceCheckRequest;
import io.grpc.CallCredentials;
import io.grpc.ClientInterceptor;
import io.grpc.Metadata;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * this is the test for server-streaming-call
 */
public class UserRoleContextTest extends AbstractInterceptorTest {

    private static final Logger log = LoggerFactory.getLogger(UserRoleContextTest.class);
    //private static final Metadata.Key<String> API_KEY = Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);


    @Override
    protected GrpcServer createServer() {
        return GrpcServer.create(6565, serverBuilder -> {
            serverBuilder.addService(new UserRoleBankService()).intercept(new UserRoleInterceptor());
        });
    }


    @Override
    protected List<ClientInterceptor> getClientInterceptor() {
        return Collections.emptyList(); // thus we are using an out of the box interceptor
    }


    @Test
    public void unaryUserCredentialsDemo() {

        for(int i=1;i<=5;i++){
            var request = BalanceCheckRequest.newBuilder()
                    .setAccountNumber(i)
                    .build();
            var response = this.blockingStub
                    .withCallCredentials(new UserRoleContextTest.UserSessionToken("user-token-"+i)) //user-specific or call-specific details are passed using this
                    .getAccountBalance(request);
            log.info("{}", response);
        }

    }


    private static class UserSessionToken extends CallCredentials {

        private static final String TOKEN_FORMAT = "%s %s";
        private final String jwt;

        public UserSessionToken(String jwt) {
            this.jwt = jwt;
        }


        @Override
        public void applyRequestMetadata(RequestInfo requestInfo, Executor executor, MetadataApplier metadataApplier) {
            var metadata = new Metadata();
            metadata.put(Constants.USER_TOKEN_KEY, TOKEN_FORMAT.formatted(Constants.BEARER, jwt));
            // now applying the metadata
            metadataApplier.apply(metadata);
        }
    }
}
