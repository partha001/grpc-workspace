package org.example.section02;

import com.partha.models.section02.Book;
import com.partha.models.section02.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * this is to show how to have composition with collections
 */
public class App08Collections {

    private static final Logger log = LoggerFactory.getLogger(App08Collections.class);


    public static void main(String[] args) {

        //create books
        var book1 = Book.newBuilder()
                .setTitle("harry potter - part1")
                .setAuthor("j.k.rowling")
                .setPublicationYear(2004)
                .build();
        var book2 = Book.newBuilder()
                .setTitle("harry potter - part2")
                .setAuthor("j.k.rowling")
                .setPublicationYear(2006)
                .build();
        var book3 = Book.newBuilder()
                .setTitle("harry potter - part3")
                .setAuthor("j.k.rowling")
                .setPublicationYear(2008)
                .build();

        var library1 = Library.newBuilder()
                .setName("fantasy library")
                .addBooks(book1)
                .addBooks(book2)
                .addBooks(book3)
                .build();
        log.info(" library: {}", library1);

        //however it is not mandatory that we have to add the books one by one.
        var library2 = Library.newBuilder()
                .setName("fantasy library")
                .addAllBooks(List.of(book1, book2, book3))
                .build();
        log.info(" library: {}", library2);
    }
}
