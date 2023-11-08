package com.ingress.bookstore.controller;

import com.ingress.bookstore.dto.responseDto.BookResponseDto;
import com.ingress.bookstore.dto.responseDto.StudentDto;
import com.ingress.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/bookstore/books/")
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService =bookService ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Integer id) {
        BookResponseDto bookResponseDto = bookService.getBookById(id);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);    }
    @GetMapping("/students/{id}")
    public List<StudentDto> getStudentByBook(@PathVariable Integer id) {
        return bookService.getStudentsByBook(id);
    }
}
