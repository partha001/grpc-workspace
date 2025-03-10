package org.example.section03;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.partha.models.section03.Person;
import com.partha.models.section03.PersonWithOptionalScalars;
import com.partha.models.section03.Sample;
import com.partha.models.section03.common.Address;
import com.partha.models.section03.common.BodyStyle;
import com.partha.models.section03.common.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

/**
 * this program is to demonstrate the behavior of optional scalars
 */
public class App15OptionalScalars {

    private static final Logger log = LoggerFactory.getLogger(App15OptionalScalars.class);


    public static void main(String[] args) {
        var addres= Address.newBuilder().setCity("bangalore").build();
        var car = Car.newBuilder().setBodyStyle(BodyStyle.COUPE).build();
        var person = PersonWithOptionalScalars.newBuilder()
                .setName("partha")
                //.setAge(35)
                .setAddress(addres)
                .setCar(car)
                .build();

        log.info("person: {}", person); //note that age in not  present
        log.info("{}",person.hasAge()); //false


        //it is to be noted that the hasAge() was earlier not there refer to App13....java since
        //the person it was using was having age as int32. but now this method shows up since since its
        //of optional type now
    }
}
