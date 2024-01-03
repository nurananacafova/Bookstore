package com.ingress.bookstore.service;

import com.ingress.bookstore.dto.responseDto.BookResponseDto;
import com.ingress.bookstore.dto.responseDto.StudentDto;

import java.util.List;

public interface BookService {
    BookResponseDto getBookById(Integer id);

    List<StudentDto> getStudentsByBook(Integer id);
}
