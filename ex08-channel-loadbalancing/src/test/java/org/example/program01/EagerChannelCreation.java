package org.example.program01;

import com.partha.program01.BankServiceGrpc;
import org.example.common.AbstractChannelTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this class is to show eager channel creation behavior . however this is only for the purpose of demo.
 * this is the standard-practice in the grpc world.
 * <p>
 * note: lazy creation of channel is the default behavior of rpc. i.e. the channel gets created on the first rpc-call made by the client.
 * however if there is a explicit requirement for eager initialization of channel then that can be done as shown below
 */
public class EagerChannelCreation extends AbstractChannelTest {

    private static final Logger log = LoggerFactory.getLogger(EagerChannelCreation.class);


    @Test
    public void eagerChannelDemo() {
        log.info("{}", channel.getState(false)); //this will give us the current state of the channel

        //however if we do channel.getState(true) it will try to the remote server . and this is the way to initlize the channel eargerly
        //but right now it now there is an going issue with the grpc-team because of which this is not working currently because of an ongoing
        // issue https://github.com/grpc/grpc-java/issues/10517 but this is the way to earger initialization of channel
        // ones this issue is fixed by the team again we will be able to do eager-initialization channel doing channel.getState(true)
    }


}
