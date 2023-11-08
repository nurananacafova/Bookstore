package com.ingress.bookstore.service;

import com.ingress.bookstore.dto.responseDto.BookResponseDto;
import com.ingress.bookstore.dto.Mapper;
import com.ingress.bookstore.dto.responseDto.StudentDto;
import com.ingress.bookstore.model.Book;
import com.ingress.bookstore.model.Student;
import com.ingress.bookstore.repository.BookRepository;
import com.ingress.bookstore.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class StudentService {
    public final StudentRepository studentRepository;
    public final BookRepository bookRepository;

    //Book
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = StreamSupport
                .stream(bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return Mapper.booksToBookResponseDtos(books);
    }

    public BookResponseDto getBookById(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("cannot find book with id: " + id));
        return Mapper.bookToBookResponseDto(book);
    }

//    public List<Book> chooseBook(Integer studentId, Integer bookId) {
//        Student student = studentRepository.findById(studentId).get();
//        student.setCurrentBooks(bookId);
//        return student.getCurrentBooks();
//    }

    public List<BookResponseDto> getCurrentlyReadingBooks(Integer studentId) {

        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new IllegalArgumentException("cannot find book with id: " + studentId));
        List<Book> books = student.getCurrentBooks();
        return Mapper.booksToBookResponseDtos(books);

    }


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    //Student
    public List<StudentDto> getAllStudent() {
        List<Student> students = StreamSupport
                .stream(studentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return Mapper.studentsToStudentResponseDtos(students);
    }

}
