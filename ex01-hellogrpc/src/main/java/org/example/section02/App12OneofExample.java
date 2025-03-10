package org.example.section02;

import com.partha.models.section02.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * oneof example
 */
public class App12OneofExample {

    private static final Logger log = LoggerFactory.getLogger(App12OneofExample.class);


    public static void main(String[] args) {
        var email = Email.newBuilder().setAddress("partha@gmail.com").setPassword("partha").build();
        var phone = Phone.newBuilder().setNumber(1234567890).setCode(91).build();

        login(Credentials.newBuilder().setEmail(email).build()); // email: address: "partha@gmail.com" password: "partha"
        login(Credentials.newBuilder().setPhone(phone).build()); // phone: number: 1234567890 code: 91

        //setting both will make it pick the last value
        login(Credentials.newBuilder().setEmail(email).setPhone(phone).build()); //phone: number: 1234567890 code: 91

        //since its oneof so even if we pass both it will only take the lastone.
    }

    private static  void login(Credentials credentials){
        switch (credentials.getLoginTypeCase()){
            case EMAIL -> log.info("email: {}", credentials.getEmail());
            case PHONE -> log.info("phone: {}", credentials.getPhone());
        }
    }
}
