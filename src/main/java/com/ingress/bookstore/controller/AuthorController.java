package com.ingress.bookstore.controller;
import com.ingress.bookstore.dto.responseDto.BookResponseDto;
import com.ingress.bookstore.model.Author;
import com.ingress.bookstore.model.Book;
import com.ingress.bookstore.service.AuthorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookstore/author")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthorController {
    public final AuthorService authorService;


    @GetMapping("/")
    public String helloUserController() {
        return "User access level";
    }

    @PostMapping("/new")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PostMapping("books/new")
    public int createBook(@RequestBody Book book) {
        return authorService.createBook(book);
    }

    @GetMapping("books/")
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<BookResponseDto> bookResponseDtos = authorService.getAllBooks();
        return new ResponseEntity<>(bookResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Integer id) {
        BookResponseDto bookResponseDto = authorService.getBookById(id);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("books/delete/{bookId}/from/{authorId}")
    public void deleteBook(@PathVariable("bookId") final Integer bookId,
                           @PathVariable("authorId") final Integer authorId) {
        authorService.deleteAuthorFromBook(bookId, authorId);
    }
}
