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

@Service
@RequiredArgsConstructor
public class BookService {
    public final BookRepository bookRepository;
    public final StudentRepository studentRepository;

    public BookResponseDto getBookById(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("cannot find book with id: " + id));
        return Mapper.bookToBookResponseDto(book);
    }

    public List<StudentDto> getStudentsByBook(Integer id) {

        Book book = bookRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("cannot find book with id: " + id));
        List<Student> students = book.getStudents();

        return Mapper.studentsToStudentResponseDtos(students);
    }
}
