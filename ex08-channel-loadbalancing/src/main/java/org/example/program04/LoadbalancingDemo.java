package org.example.program04;

public class LoadbalancingDemo {

    private static class BankInstance1 {
        public static void main(String[] args) {
            GrpcServer.create(6565, new BankService())
                    .start()
                    .await();
        }
    }

    private static class BankInstance2 {
        public static void main(String[] args) {
            GrpcServer.create(7575, new BankService())
                    .start()
                    .await();
        }
    }
}
