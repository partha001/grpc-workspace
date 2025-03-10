package org.example.section02;

import com.partha.models.section02.Address;
import com.partha.models.section02.School;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * working with default values.
 */
public class App11DefaultValues {

    private static final Logger log = LoggerFactory.getLogger(App11DefaultValues.class);


    public static void main(String[] args) {
        var school = School.newBuilder().build();
        log.info("{}", school.getId()); //log-op: 0
        //this the default value for id is 0 since it is of integer type

        log.info("{}",school.getName());  //dosnt give any output and neither logs null
        //thus proto-builder under the hood fills it with empty string

        log.info("{}",school.getAddress().getCity()); //dosnt give any output and neither throws null-pointer
        //while trying to fetch city from address [the address is suppossed to be null]

        //this behavior is because Address here is filled with Address.getDefaultInstance()
        //and hence it fetches the city from that default instance.
        //lets verify this
        log.info(".equals comparison for  default instance:{}", school.getAddress().equals(Address.getDefaultInstance())); //op: True
        log.info("== comparison for  default instance:{}", school.getAddress()==Address.getDefaultInstance()); //op: true

        //this also presents a new requirement to know if a value is actually set by user or is it a default value
        //this can be understood by using
        log.info("has address? {}",school.hasAddress()); //op:false
        //thus the has...() tell us if the value has been set or not. false mean its the default value and it has not been set

        Address address = Address.newBuilder().build();
        var school2 = School.newBuilder().setAddress(address).build();
        log.info("has address : {}", school2.hasAddress()); //true
        log.info("school2.address is default address:{}", school2.getAddress().equals(address)); //true
        // the above since it does content-comparison with the default-address instance. and we have not set any value in the address object that we have created.
        log.info("school2.address is == address:{}", school2.getAddress()== Address.getDefaultInstance());//false
        // the above returns false since school has a address that we have created and set which is not the default instance


        /* thus to recap these are the default value
        int : 0
        string : ''
        map : {} i.e emptymap
        list : [] i.e emptylist
        enum: enum with fieldnumber 0. that is why while declaring enum it complains it we dont provide field-number 0. using it determines the default value
         */
    }
}
