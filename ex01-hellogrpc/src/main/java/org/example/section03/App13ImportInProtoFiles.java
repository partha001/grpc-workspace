package org.example.section03;

import com.partha.models.section03.Person;
import com.partha.models.section03.common.Address;
import com.partha.models.section03.common.BodyStyle;
import com.partha.models.section03.common.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * the proto in this related program shown how to import messages
 *  which are defined in some other proto files
 */
public class App13ImportInProtoFiles {

    private static final Logger log = LoggerFactory.getLogger(App13ImportInProtoFiles.class);


    public static void main(String[] args) {

        var addres= Address.newBuilder().setCity("bangalore").build();
        var car = Car.newBuilder().setBodyStyle(BodyStyle.COUPE).build();
        var person = Person.newBuilder()
                .setName("partha")
                .setAge(35)
                .setAddress(addres)
                .setCar(car)
                .build();

        log.info("person: {}", person);
    }

}
