package org.example.program01;

import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Empty;
import com.partha.program01.AccountBalance;
import com.partha.program01.AllAccountsResponse;
import com.partha.program01.BalanceCheckRequest;
import com.partha.program01.BankServiceGrpc;
import com.partha.program01.DepositRequest;
import com.partha.program01.Money;
import com.partha.program01.WithdrawRequest;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    private Map<Integer, Integer> accounts = new HashMap<>();


    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

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

    @Override
    public void getAllAccounts(Empty request, StreamObserver<AllAccountsResponse> responseObserver) {
        var accounts = AccountRepository.getAllAccounts()
                .entrySet().stream()
                .map(e -> AccountBalance.newBuilder().setAccountNumber(e.getKey()).setBalance(e.getValue()).build())
                .toList();
        var response = AllAccountsResponse.newBuilder().addAllAccounts(accounts).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void withdraw(WithdrawRequest request, StreamObserver<Money> responseObserver) {
        /**
         * indieally we should do some input validation. But we are goign to assume only happy path scenarios.
         * Becuase in gRPC, there are multiple ways to communicate the error message to the client. It has to be
         * discussed in details later
         * Assumption: account#1 - 10 & withdraw amount is multiple of $10
         */
        var accountNumber = request.getAccountNumber();
        var requestAmount = request.getAmount();
        var accountBalance = AccountRepository.getBalance(accountNumber);

        if (requestAmount > accountBalance) {
            responseObserver.onCompleted(); //this will be changed to proper error handling later
            return;
        }

        for (int i = 0; i < (requestAmount / 10); i++) {
            var money = Money.newBuilder().setAmount(10).build();
            responseObserver.onNext(money);
            logger.info("money sent {}", money);
            //we also need to deduct the money that is being dispatched
            AccountRepository.deductAmount(accountNumber, 10);
            //also adding some delay. this is similar to Thread.sleep but it doesnt throw that InterruptedException.
            //so no hassle of error-handling with try-catch block
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<DepositRequest> deposit(StreamObserver<AccountBalance> responseObserver) {
        return new DepositRequestHandler(responseObserver);
    }
}



