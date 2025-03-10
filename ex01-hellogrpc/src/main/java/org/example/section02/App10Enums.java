package org.example.section02;

import com.partha.models.section02.DayOfWeek;
import com.partha.models.section02.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * working with enums in .proto files
 */
public class App10Enums {

    private static final Logger log = LoggerFactory.getLogger(App10Enums.class);


    public static void main(String[] args) {
        var event1 = Event.newBuilder()
                .setName("event1")
                .setDayOfWeek(DayOfWeek.SUNDAY)
                .build();
        log.info("eventDefition: {}",event1);
        //note that for the above log the day of week doesnt show up in log
        //however if we log it separately then in shows up in the log
        log.info("eventDay:{}", event1.getDayOfWeek());

        //but for monday it comes up in the log when we log the event-definition
        var event2 = Event.newBuilder()
                .setName("event2")
                .setDayOfWeek(DayOfWeek.MONDAY)
                .build();
        log.info("eventDefition: {}",event2);

       //this is due to the optimizations that protobuf applies on the message.
       //hence this behavior.
    }
}
