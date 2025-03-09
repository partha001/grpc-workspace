package org.example.section02;

import com.partha.models.section02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * serialization and deserialization of proto-buff objects
 */
public class App05SerializationAndDeserialization {

    private static final Logger log = LoggerFactory.getLogger(App05SerializationAndDeserialization.class);

    private static final Path PATH = Path.of("person.txt");

    public static void main(String[] args)  {
        var person1 = Person.newBuilder()
                .setLastName("biswas")
                .setAge(35)
                .setEmail("partha@gmail.com")
                .setEmployed(true)
                .setSalary(500000)
                .setBankAccountNumber(123456789)
                .setBalance(-100)
                .build();
        log.info("serializing Person:{}" , person1);

        //to write this object to some outputstream we can simply do
        //person1.writeTo(someoutputStream);

        serialize(person1);

        //similarly to deserialize we just have to do
        //Person.parseFrom(someInputStream)

        var person2 = deserialize();
        log.info("deserializedPerson:{}" , person2);

        //lets compare
        log.info("equals comparison result:{}", person1.equals(person2)); //prints true as it does content value comparison
        log.info("= comparison result:{}", person1==person2); //prints false as it does referrece comparison

        //lests check the byte array length
        log.info("bytes length: {}", person2.toByteArray().length);


    }

    public static void serialize(Person person)  {
        //person.writeTo(Files.newOutputStream(PATH));

        try(var stream = Files.newOutputStream(PATH)){
            person.writeTo(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Person deserialize() {
        //return Person.parseFrom(Files.newInputStream(PATH));
        try(var stream = Files.newInputStream(PATH)){
            return Person.parseFrom(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
