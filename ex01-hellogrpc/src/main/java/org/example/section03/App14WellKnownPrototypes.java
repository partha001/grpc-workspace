package org.example.section03;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.partha.models.section03.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

/**
 * this program and its corresponding proto files show we can
 * leverage out-of the box well-known types
 */
public class App14WellKnownPrototypes {

    private static final Logger log = LoggerFactory.getLogger(App14WellKnownPrototypes.class);


    public static void main(String[] args) {
        var sample  = Sample.newBuilder()
                .setAge(Int32Value.of(35))
                .setLoginTime(Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build())
                .build();


        //the benefit of using these wrapper-types is that now it enables us to these kind of checks:
        log.info("{}",sample.hasAge()); //true

        //have we defined age as int i.e. scalar type it should always give us value zero
        //which is the default value for int scalar data types.


        log.info("{}", Instant.ofEpochSecond(sample.getLoginTime().getSeconds())); // 2025-03-10T13:18:27Z


    }
}
