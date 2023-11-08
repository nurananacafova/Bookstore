package com.ingress.bookstore.dto;


//import com.ingress.bookstore.dto.responseDto.AuthorDto;
import com.ingress.bookstore.dto.responseDto.AuthorResponseDto;
import com.ingress.bookstore.dto.responseDto.BookResponseDto;
import com.ingress.bookstore.dto.responseDto.StudentDto;
import com.ingress.bookstore.model.Author;
import com.ingress.bookstore.model.Book;
import com.ingress.bookstore.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mapper {


    public static BookResponseDto bookToBookResponseDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setBookId(book.getBookId());
        bookResponseDto.setName(book.getName());
        bookResponseDto.setAuthorNames(book.getAuthor().getClass().getName());
//        bookResponseDto.setCategoryName(book.getCategory().getName());
        String name = null;
        List<Author> authors = book.getAuthor();
        for (Author author : authors) {
            name = author.getName();
        }
        bookResponseDto.setAuthorNames(name);
        return bookResponseDto;
    }


    public static List<BookResponseDto> booksToBookResponseDtos(List<Book> books) {
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book book : books) {
            bookResponseDtos.add(bookToBookResponseDto(book));
        }
        return bookResponseDtos;
    }


    public static AuthorResponseDto authorToAuthorResponseDto(Author author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setAuthorId(author.getId());
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setBookNames(author.getBooks().getClass().getName());
        authorResponseDto.setSubscriptions(author.getSubscribedStudents().getClass().getName());
        String name = null;
        String subscriberName=null;
        List<Book> books = author.getBooks();
        List<Student>students=author.getSubscribedStudents();
        for (Book book : books) {
            name = book.getName();
        }
        for (Student student: students){
            subscriberName=student.getName();
        }

        authorResponseDto.setBookNames(name);
        authorResponseDto.setSubscriptions(subscriberName);
        return authorResponseDto;
    }

    public static List<AuthorResponseDto> authorsToAuthorResponseDtos(List<Author> authors) {
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        for (Author author : authors) {
            authorResponseDtos.add(authorToAuthorResponseDto(author));
        }
        return authorResponseDtos;
    }

    public static StudentDto studentToStudentResponseDto(Student student) {
        StudentDto studentResponseDto = new StudentDto();
        studentResponseDto.setStudentId(student.getId());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setMail(student.getMail());
        String name = null;
        return studentResponseDto;
    }

    public static List<StudentDto> studentsToStudentResponseDtos(List<Student> students) {
        List<StudentDto> studentResponseDtos = new ArrayList<>();
        for (Student student : students) {
            studentResponseDtos.add(studentToStudentResponseDto(student));
        }
        return studentResponseDtos;
    }
}
