package org.example.program02;

import java.io.IOException;

public class Ex05Program02 {

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer.create(new FlowControlService())
                .start()
                .await();
    }
}
