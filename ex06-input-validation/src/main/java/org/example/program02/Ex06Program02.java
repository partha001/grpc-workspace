package org.example.program02;

import java.io.IOException;

/**
 * writing test case for server-error
 */
public class Ex06Program02 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new BankService()).start().await();
    }
}
