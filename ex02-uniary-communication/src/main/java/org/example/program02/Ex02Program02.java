package org.example.program02;

/**
 * its an advancement over the previous program where we make the below changes
 * 1. create a class AccountRepository . this is to simulate the database
 * 2. refactor the server creation code. i.e we have created a new class called GrpcServer and moved all the server related code to it.
 */
import java.io.IOException;

/**
 * this program is to show how to implement a simple grpc service
 */
public class Ex02Program02 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
