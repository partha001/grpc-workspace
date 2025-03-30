package org.example.program03;

import com.partha.program03.ErrorMessage;
import com.partha.program03.ValidationCode;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;

import java.util.Map;
import java.util.Optional;

public class RequestValidator {

    private static final Metadata.Key<ErrorMessage> ERROR_MESSAGE_KEY = ProtoUtils.keyForProto(ErrorMessage.getDefaultInstance());

    //    public static Optional<Status> validateAccount(int accountNumber){
//        if(accountNumber>0 && accountNumber<11){
//            return Optional.empty();
//        }
//        return Optional.of(Status.INVALID_ARGUMENT.withDescription("account number should be between 1 and 10"));
//    }

    public static Optional<StatusRuntimeException> validateAccount(int accountNumber) {
        if (accountNumber > 0 && accountNumber < 11) {
            return Optional.empty();
        }
        var metadata = toMetadata(ValidationCode.INVALID_ACCOUNT);
        return Optional.of(Status.INVALID_ARGUMENT.asRuntimeException(metadata));

        //return Optional.of(Status.INVALID_ARGUMENT.withDescription("account number should be between 1 and 10").asRuntimeException(metadata));
    }


    public static Optional<StatusRuntimeException> isAmountDivisibleBy10(int amount) {
        if (amount > 0 && amount % 10 == 0) {
            return Optional.empty();
        }
        //return Optional.of(Status.INVALID_ARGUMENT.withDescription("requested amount should be in multiple of 10"));
        var metadata = toMetadata(ValidationCode.INVALID_AMOUNT);
        return Optional.of(Status.INVALID_ARGUMENT.asRuntimeException(metadata));
    }

    public static Optional<StatusRuntimeException> hasSufficientBalance(int amount, int balance) {
        if (amount <= balance) {
            return Optional.empty();
        }
        //return Optional.of(Status.FAILED_PRECONDITION.withDescription("insufficient balance"));
        var metadata = toMetadata(ValidationCode.INSUFFICIENT_BALANCE);
        return Optional.of(Status.FAILED_PRECONDITION.asRuntimeException(metadata));
    }


//    private static Metadata toMetadata(ValidationCode code) {
//        var metadata = new Metadata();
//        //Map<Key<T>,T value> map; //the trailer metadata is  map of type shown aside
//        var key = ProtoUtils.keyForProto(ErrorMessage.getDefaultInstance());
//        var errorMessage = ErrorMessage.newBuilder()
//                .setValidationCode(code)
//                .build();
//        metadata.put(key, errorMessage); //this will also work fine. however since the key will be same everytime so we can take it at the class level
//        return metadata;
//    }

    /**
     * this is the same as the above method . just that since the key remains same we have refactored the code a little by declaring
     * ERROR_MESSAGE_KEY at the class level and then making use of it here
     */
    private static Metadata toMetadata(ValidationCode code) {
        var metadata = new Metadata();
        var errorMessage = ErrorMessage.newBuilder()
                .setValidationCode(code)
                .build();
        metadata.put(ERROR_MESSAGE_KEY, errorMessage);

        //additionally to send the error message as string and not as binary we have to the following
        var key = Metadata.Key.of("desc", Metadata.ASCII_STRING_MARSHALLER);
        metadata.put(key, code.toString());

        return metadata;
    }
}
