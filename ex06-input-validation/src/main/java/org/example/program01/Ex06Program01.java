package org.example.program01;

import java.io.IOException;

/**
 * this program is to explore input-validation
 */
public class Ex06Program01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new BankService()).start().await();
    }
}
