package org.example.section02;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.partha.models.section02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
this is to furthur deepdive into the reasons behind the performance gain by proto
 */
public class App06ProtoVsJson2 {

    private static final Logger log = LoggerFactory.getLogger(App06ProtoVsJson2.class);

    private static final Path PATH = Path.of("person.txt");

    //private static final ObjectMapper mapper = new ObjectMapper();


    public static void main(String[] args) {
        var protoPerson = Person.newBuilder()
//                .setLastName("biswas")
//                .setAge(35)
//                .setEmail("partha@gmail.com")
                .setEmployed(false)
//                .setSalary(500000)
//                .setBankAccountNumber(123456789)
//                .setBalance(-100)
                .build();

        /**
         * if the above object is to be serialized into json it will be something like the below:
         * {"employed":true}
         *
         * since all of it is text [including the fieldname which consists of characters] so it will have considerable size.
         *
         * however when the same is serialized by proto it will just have the fieldnumber and the value so it will be something like
         * 41 [where 4 is the field-number and value true and false is compressed to 0 and 1]
         * thus the payload compressed to an amazing degree
         */


        //another intersting thing to note that if set set employed=false and then serialize we will find that there is
        //no content in the output file.

        log.info("personProto: {}", protoPerson);
        serialize(protoPerson);

        var person2 = deserialize();
        log.info("deserialized personProto: {}",person2);

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

