package org.example.program04;

/**
 * this program is an extension to the previous program where for the server-side everything remains the same .
 * here additionally we add a calls Client class called.
 */

import java.io.IOException;

/**
 * this program is to show how to implement a simple grpc service
 */
public class Ex02Program04 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
