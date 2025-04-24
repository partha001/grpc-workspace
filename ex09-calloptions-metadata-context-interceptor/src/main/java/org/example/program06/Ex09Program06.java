package org.example.program06;

import java.io.IOException;

public class Ex09Program06 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
