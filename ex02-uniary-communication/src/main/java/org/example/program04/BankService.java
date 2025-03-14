package org.example.program04;

import com.google.protobuf.Empty;
import com.partha.program04.AllAccountsResponse;
import com.partha.program04.BalanceCheckRequest;
import io.grpc.stub.StreamObserver;
import com.partha.program04.BankServiceGrpc;
import com.partha.program04.AccountBalance;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        var accountNumber = request.getAccountNumber();
        var balance = AccountRepository.getBalance(accountNumber);
        var accountBalance = com.partha.program04.AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(balance)
                .build();
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllAccounts(Empty request, StreamObserver<AllAccountsResponse> responseObserver) {
        var accounts = AccountRepository.getAllAccounts()
                .entrySet().stream()
                .map(e -> AccountBalance.newBuilder().setAccountNumber(e.getKey()).setBalance(e.getValue()).build())
                .toList();
        var response =AllAccountsResponse.newBuilder().addAllAccounts(accounts).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
