package org.example.program01;

import com.partha.program01.AccountBalance;
import com.partha.program01.TransferRequest;
import com.partha.program01.TransferResponse;
import com.partha.program01.TransferStatus;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransferRequestHandler implements StreamObserver<TransferRequest> {

    private static final Logger log = LoggerFactory.getLogger(TransferRequestHandler.class);
    private final StreamObserver<TransferResponse> responseObserver;

    public TransferRequestHandler(StreamObserver<TransferResponse> responseObserver) {
        this.responseObserver = responseObserver;
    }

    @Override
    public void onNext(TransferRequest transferRequest) {
        var status = this.transfer(transferRequest);
        var response = TransferResponse.newBuilder()
                .setFromAccount(this.toAccountBalance(transferRequest.getFromAccount()))
                .setToAccount(this.toAccountBalance(transferRequest.getToAccount()))
                .setStatus(status)
                .build();
        this.responseObserver.onNext(response);
        /**
         *  not doing onComplete here since its birectional communation and the channel needs to remain open
         *  for further onNext. thus in this case the onCompleted will be triggered from the client-side
         *  after it has done all the transfers
         */
    }


//    /**
//     * note that its not mandatory for the server to respond to the client on its every stream message.
//     * say for example in this case if we want the server to respond only on transfer success then we can
//     * code the onNext method as shown below
//     * @param transferRequest
//     */
//    @Override
//    public void onNext(TransferRequest transferRequest) {
//        var status = this.transfer(transferRequest);
//        if(TransferStatus.COMPLETED.equals(status)){
//            var response = TransferResponse.newBuilder()
//                    .setFromAccount(this.toAccountBalance(transferRequest.getFromAccount()))
//                    .setToAccount(this.toAccountBalance(transferRequest.getToAccount()))
//                    .setStatus(status)
//                    .build();
//
//            this.responseObserver.onNext(response);
//        }
//    }

    @Override
    public void onError(Throwable throwable) {
        log.info("client error {}", throwable.getMessage());
    }

    /**
     * thus ones the client notifies that its done doing call the transfer that the time
     * the server's onComplete is triggered.
     */
    @Override
    public void onCompleted() {
        log.info("transfer request stream completed");
        this.responseObserver.onCompleted();
    }


    private TransferStatus transfer(TransferRequest request){
        var amount = request.getAmount();
        var fromAccount = request.getFromAccount();
        var toAccount = request.getToAccount();
        var status = TransferStatus.REJECTED;

        //doing some basic validation
        if(AccountRepository.getBalance(fromAccount)>=amount && (fromAccount!=toAccount)){
            AccountRepository.deductAmount(fromAccount, amount);
            AccountRepository.addAmount(toAccount, amount);
            status = TransferStatus.COMPLETED;
        }
        return status;
    }


    private AccountBalance toAccountBalance(int accountNumber){
        return AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(AccountRepository.getBalance(accountNumber))
                .build();
    }

}
