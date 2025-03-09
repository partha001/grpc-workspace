package org.example.section01;

import com.partha.models.section01.Person1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this program is to inspect how the proto-generated class objects behave.
 */
public class App03 {

    private static final Logger log = LoggerFactory.getLogger(App03.class);

    public static void main(String[] args) {

        //create instance of person1
        var person1 = createPerson();

        //creating another person
        var person2 = createPerson();

        //comparison behavior
        log.info("equals comparison result:{}", person1.equals(person2)); //prints true as it does content value comparison
        log.info("= comparison result:{}", person1==person2); //prints false as it does referrece comparison

        //mutability: fasle. these objects are immutable and no setters are available
        //person2.set

        //create another object with different value
        //this takes the initial values from person1
        //creates another new object with new values based upon the setters used
        var person3 = person1.toBuilder()
                .setAge(36)
                .build();

        //null attributes
        //var person4 = person1.toBuilder().setName(null).build();
        //log.info("person4:{}", person4.toString());
//        //however the above log when uncommented gives the below error
//            Exception in thread "main" java.lang.NullPointerException
//            at com.partha.models.section01.Person1$Builder.setName(Person1.java:483)
//            at org.example.section01.App03.main(App03.java:34)

        /**
         * thus grpc doesnt allow null for serialization and other issues. thus if there is
         * requirement to set null or say a doesnt attribute doesnt have any value then we have to call clear()
         */
        var person5 = person1.toBuilder().clearName().build();
        log.info("person5:{}", person5.toString());

        //howver the below code works perfectly fine. note that we havent set name and its null.
        var person6 = Person1.newBuilder()
                .setAge(10)
                .build();
        log.info("person6:{}", person6); //output: person6:age: 10



    }

    private static Person1 createPerson(){
        return Person1.newBuilder()
                .setName("partha")
                .setAge(35)
                .build();
    }
}
