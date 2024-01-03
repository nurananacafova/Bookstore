package com.ingress.bookstore.service;

import com.ingress.bookstore.dto.responseDto.BookResponseDto;
import com.ingress.bookstore.dto.responseDto.StudentDto;
import com.ingress.bookstore.model.Student;

import java.util.List;

public interface StudentService {
    List<BookResponseDto> getAllBooks();
    BookResponseDto getBookById(Integer id);
    List<BookResponseDto> getCurrentlyReadingBooks(Integer studentId);
    Student createStudent(Student student);
    List<StudentDto> getAllStudent();
}
