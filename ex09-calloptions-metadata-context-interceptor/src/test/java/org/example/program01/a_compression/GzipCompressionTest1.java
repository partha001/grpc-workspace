package org.example.program01.a_compression;

import com.partha.program01.BalanceCheckRequest;
import org.example.program01.AbstractTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GzipCompressionTest1 extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(GzipCompressionTest1.class);

    @Test
    public void gzipDemo() {
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        var response = this.blockingStub
                .withCompression("gzip")
                .getAccountBalance(request);
        log.info("{}", response);
    }
}
