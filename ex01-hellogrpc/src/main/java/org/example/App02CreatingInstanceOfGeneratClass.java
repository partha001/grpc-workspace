package org.example;

import com.partha.models.PersonOuterClass;

/**
 * this program shows how to create instance of a class i.e. Person which is generated from the
 * .proto file.
 */
public class App02CreatingInstanceOfGeneratClass {

    public static void main(String[] args) {

        //now the Person is actually an inner class insie PersonOuterClass and moreover its constructor is private.
        //however a builder is available inside it. thus we will be creating the person using builder to create the object
        //as shown below
        PersonOuterClass.Person person1 = PersonOuterClass.Person.newBuilder()
                .setName("Partha")
                .setAge(35)
                .build();


//        //however a better approach is to use the var and declare it like
//        var person1 = PersonOuterClass.Person.newBuilder()
//                .setName("Partha")
//                .setAge(35)
//                .build();
        System.out.println("hello grpc "+ person1.hashCode());
    }
}
