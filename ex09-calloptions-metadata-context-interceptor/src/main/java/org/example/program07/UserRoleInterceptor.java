package org.example.program07;

import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Set;

/**
 *  the below interceptor is meant to find the role from the token and then set it in the context
 *  * user-token-1, user-token-2   => prime users, thus correspond to UserRole.PRIME role
 *  * user-token-3 , user-token-4  => standard users, correspond to UserRole.STANDARD
 *  * any other token              =>  not valid ... !
 */
public class UserRoleInterceptor implements ServerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(UserRoleInterceptor.class);

    private static final Set<String> PRIME_SET = Set.of("user-token-1","user-token-2");
    private static final Set<String> STANDARD_SET = Set.of("user-token-3", "user-token-4");

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {

        //Context.current().

        var token = extractToken(metadata.get(Constants.USER_TOKEN_KEY));
        log.info("{}",token); // this is just for debugging purposes
        var ctx = toContext(token);
        if(Objects.nonNull(ctx)){

            /** normally we initiate the serverCall as below . however we cant do this here.
             * this is because this passes the current context to the server. however in this particular case we have a
             * new context object ie.. the ctx which contains the added info . and thus we need to pass this new context
             * to the server**/
            //serverCallHandler.startCall(serverCall, metadata);

            /** therefore in this case we have to do **/
            return Contexts.interceptCall(ctx, serverCall, metadata, serverCallHandler);
        }

        return close(serverCall,metadata, Status.PERMISSION_DENIED.withDescription("user is not allowed"));
    }

    private String extractToken(String value){
        return Objects.nonNull(value) && value.startsWith(Constants.BEARER) ?
                value.substring(Constants.BEARER.length()).trim(): null;
    }

    private Context toContext(String token){
        if( Objects.nonNull(token) && (PRIME_SET.contains(token) || STANDARD_SET.contains(token))){
            var role = PRIME_SET.contains(token)? UserRole.PRIME : UserRole.STANDARD;
            return Context.current().withValue(Constants.USER_ROLE_KEY, role);  //one can think of the Context.current() like a ThreadLocal
            // is it also to be noted that here above we are not mutating the existing current object. but creating a new one with the added value and then returning it

        }
        return null;
    }

    private <ReqT, RespT> ServerCall.Listener<ReqT> close(ServerCall<ReqT, RespT> serverCall, Metadata metadata, Status status){
        serverCall.close(status, metadata);
        return new ServerCall.Listener<ReqT>(){
        };
    }
}
