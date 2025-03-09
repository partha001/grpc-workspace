package org.example.section02;

import com.partha.models.section02.Person;
import org.example.section01.App03;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this program is to show that how protobuf handles null fiels.
 *
 * thus in other words. it doesnt allow user to set null into fields manually
 */
public class App04WorkingWithDatatypes {

    private static final Logger log = LoggerFactory.getLogger(App04WorkingWithDatatypes.class);

    public static void main(String[] args) {
        var person1 = Person.newBuilder()
                .setLastName("biswas")
                .setAge(35)
                .setEmail("partha@gmail.com")
                .setEmployed(true)
                .setSalary(500000)
                .setBankAccountNumber(123456789)
                .setBalance(-100)
                .build();
        log.info("person-details:{}", person1);

        //note that though we have not set some of the fields and how protobuf has handled the object creation and serialization
        var person2 = Person.newBuilder()
                .setLastName("biswas")
                .setAge(35)
                .build();
        log.info("person-details:{}", person2);
    }
}
