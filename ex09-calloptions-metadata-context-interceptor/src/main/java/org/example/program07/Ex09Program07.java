package org.example.program07;

import java.io.IOException;

public class Ex09Program07 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new UserRoleBankService())
                .start()
                .await();
    }
}
