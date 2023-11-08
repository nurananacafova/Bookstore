package com.ingress.bookstore.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BookstoreRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    private BookRepository bookRepository;

//    @Test
//    public void StudentRepository_SaveStude
//    @Test
//    public void StudentRepository_GetBooks_RetunAllBooks() {
//        //arrange
//
////        BookDto book= BookDto.builder().getClass()
//        //act`
//
//        //assert
//    }
}
