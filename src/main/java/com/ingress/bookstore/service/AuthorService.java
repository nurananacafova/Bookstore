package com.ingress.bookstore.service;

import com.ingress.bookstore.dto.responseDto.BookResponseDto;
import com.ingress.bookstore.dto.Mapper;
import com.ingress.bookstore.model.Author;
import com.ingress.bookstore.model.Book;
import com.ingress.bookstore.repository.AuthorRepository;
import com.ingress.bookstore.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class AuthorService  {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

//    public List<AuthorResponseDto> aaa(int id) {
//        Book book = bookRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException("cannot find book with id: " + id));
//        List<Author> authors = book.getAuthor();
//        return Mapper.authorsToAuthorResponseDtos(authors);
//    }
//
//    public StudentDto getStudentByAuthor(int id) {
//        Author author = authorRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException("cannot find book with id: " + id));
//        Student student = (Student) author.getSubscribedStudents();
//        return Mapper.studentToStudentResponseDto(student);
//    }
//
//    public static AuthorResponseDto getstudentSubscriber(Author author) {
//        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
//        authorResponseDto.setSubscriptions(author.getSubscribedStudents().getClass().getName());
//        String subscriberName = null;
//        List<Student> students = author.getSubscribedStudents();
//        for (Student student : students) {
//            subscriberName = student.getName();
//        }
//        authorResponseDto.setSubscriptions(subscriberName);
//        return authorResponseDto;
//    }
//
//
    public int createBook(Book book) {
        bookRepository.save(book);
//        String studentMail=        authorDtos.getSubscriptions();
//        MailModel mailModel=new MailModel();
//        mailModel.setTo(studentMail);
//        mailModel.setSubject("New book created!");
//        mailModel.setMessage("Book name: "+book.getName()+"\n Author: "+book.getAuthor());
//        service.sendMail(studentMail,mailModel);
        return book.getBookId();
    }

    public List<BookResponseDto> getAllBooks() {
        List<Book> books = StreamSupport
                .stream(bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return Mapper.booksToBookResponseDtos(books);

    }

    public BookResponseDto getBookById(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Cannot find book with id: " + id));
        return Mapper.bookToBookResponseDto(book);
    }

    @Transactional
    public void deleteAuthorFromBook(Integer bookId, Integer authorId) {
        Book book = bookRepository.findById(bookId).get();
        Author author = authorRepository.findById(authorId).get();

        if (!(book.getAuthor().contains(author))) {
            throw new IllegalArgumentException("Book does not have this author!");
        }
        book.deleteAuthor(author);
        author.removeBook(book);
        author.getBooks().clear();
        book.getAuthor().clear();
        bookRepository.deleteById(bookId);
    }

}

