package org.example.section02;

import com.partha.models.section02.Address;
import com.partha.models.section02.School;
import com.partha.models.section02.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this program is to demonstrate componsiton i.e where one proto message
 * is inserted into another.
 */
public class App07Composition {

    private static final Logger log = LoggerFactory.getLogger(App06ProtoVsJson2.class);

    public static void main(String[] args) {
        var address = Address.newBuilder()
                .setStreet("123 main street")
                .setCity("kolkata")
                .setState("west-bengal")
                .build();

        var student = Student.newBuilder()
                .setName("aishani")
                .setAddress(address)
                .build();

        var school = School.newBuilder()
                .setId(1)
                .setName("some-school")
                .setAddress(address.toBuilder().setCity("456 main street"))
                .build();

        log.info("school: {}", school);
        log.info("student: {}",student);

    }
}
