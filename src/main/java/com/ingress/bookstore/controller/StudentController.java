package com.ingress.bookstore.controller;

import com.ingress.bookstore.dto.responseDto.BookResponseDto;
import com.ingress.bookstore.dto.responseDto.StudentDto;
import com.ingress.bookstore.model.Book;
import com.ingress.bookstore.model.Student;
import com.ingress.bookstore.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bookstore/students")
@CrossOrigin("*")
@RequiredArgsConstructor

public class StudentController {

    public final StudentService studentService;
    private final ModelMapper modelMapper;

    @GetMapping("/books/all")
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<BookResponseDto> bookResponseDtos = studentService.getAllBooks();
        return new ResponseEntity<>(bookResponseDtos, HttpStatus.OK);

    }


    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Integer id) {
        BookResponseDto bookResponseDto = studentService.getBookById(id);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);


    }

    @GetMapping("/books/active/{id}")
    public List<BookResponseDto> getCurrentlyReadingBooks(@PathVariable Integer id) {
        return studentService.getCurrentlyReadingBooks(id);
    }

    @PostMapping("/new")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
//
//    @PostMapping("/addCurrentBook")
//    public ResponseEntity<List<Book>> addCurrentBook(@RequestBody Integer studentId, Integer bookId) {
//        List<Book> books = studentService.chooseBook(studentId, bookId);
//        return new ResponseEntity<>(books, HttpStatus.OK);
//    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentDtos = studentService.getAllStudent();
        return new ResponseEntity<>(studentDtos, HttpStatus.OK);
    }


}
