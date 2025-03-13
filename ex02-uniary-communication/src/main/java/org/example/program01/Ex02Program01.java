package org.example.program01;

import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * this program is to show how to implement a simple grpc service
 */
public class Ex02Program01 {

    public static void main(String[] args) throws IOException, InterruptedException {

        //creating the grpc server
        var server = ServerBuilder.forPort(6565)
                .addService(new BankService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
