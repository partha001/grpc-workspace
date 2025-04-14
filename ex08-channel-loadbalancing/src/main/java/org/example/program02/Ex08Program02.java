package org.example.program02;

import java.io.IOException;

public class Ex08Program02 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
