package org.example.program01;

import java.io.IOException;

public class Ex08Program01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
