package org.example.program04;

import java.io.IOException;

public class Ex09Program04 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
