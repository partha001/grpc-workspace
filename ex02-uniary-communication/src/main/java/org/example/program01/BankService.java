package org.example.program01;

import com.partha.program01.AccountBalance;
import com.partha.program01.BalanceCheckRequest;
import io.grpc.stub.StreamObserver;

public class BankService extends com.partha.program01.BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        //super.getAccountBalance(request, responseObserver);

        var accountNumber = request.getAccountNumber();
        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(100000)
                .build();
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }
}
