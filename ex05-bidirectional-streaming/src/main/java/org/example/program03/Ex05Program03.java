package org.example.program03;

import java.io.IOException;

public class Ex05Program03 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new GuessNumberService())
                .start()
                .await();
    }
}
