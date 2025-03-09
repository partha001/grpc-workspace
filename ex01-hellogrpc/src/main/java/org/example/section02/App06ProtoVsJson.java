package org.example.section02;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.partha.models.section02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * json vs proto.
 * this is because proto is serialized and desealized as binary
 * whereas json is serialized and deserialized as text
 */
public class App06ProtoVsJson {

    private static final Logger log = LoggerFactory.getLogger(App06ProtoVsJson.class);

    private static final ObjectMapper mapper = new ObjectMapper();


    public static void main(String[] args) {
        var protoPerson = Person.newBuilder()
                .setLastName("biswas")
                .setAge(35)
                .setEmail("partha@gmail.com")
                .setEmployed(true)
                .setSalary(500000)
                .setBankAccountNumber(123456789)
                .setBalance(-100)
                .build();

        var jsonPerson = new JsonPerson("biswas",35, "partha@gmail.com",true, 500000, 123456789,-100);

        for(int i=0;i<5;i++){
            runTest("json", ()-> json(jsonPerson));
            runTest("proto", ()-> proto(protoPerson));
        }

    }

    private static void proto(Person person){
        try{
            var bytes = person.toByteArray();
            Person.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private static void json(JsonPerson person){
        try {
            byte[] bytes = mapper.writeValueAsBytes(person);
            mapper.readValue(bytes, JsonPerson.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void runTest(String testName, Runnable runnable){
        var start = System.currentTimeMillis();
        for(int i=0;i<1_000_000;i++){
            runnable.run();
        }
        var end = System.currentTimeMillis();
        log.info("time taken for {} - {}", testName, (end-start));
    }
}

/**
 * it is to be noted that for the first iteration proto performs slow . this is because java takes some warmup time.
 * but later it proto outshines json consistently.
 *
 * also this difference will increase in we increase the number of iteration inside runTest()
 */
