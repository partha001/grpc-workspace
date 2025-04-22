package org.example.program05;

import java.io.IOException;

public class Ex09Program05 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
