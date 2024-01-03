package com.ingress.bookstore.service;

import com.ingress.bookstore.dto.responseDto.BookResponseDto;
import com.ingress.bookstore.model.Author;
import com.ingress.bookstore.model.Book;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
//    Author getAuthorByMail(String mail);
    int createBook(Book book);
    List<BookResponseDto> getAllBooks();
    BookResponseDto getBookById(Integer id);
    void deleteAuthorFromBook(Integer bookId, Integer authorId);
}
