package org.example.program02;

import com.partha.program02.AccountBalance;
import com.partha.program02.BalanceCheckRequest;
import io.grpc.stub.StreamObserver;

public class BankService extends com.partha.program02.BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        var accountNumber = request.getAccountNumber();
        var balance = AccountRepository.getBalance(accountNumber);
        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(balance)
                .build();
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }
}
