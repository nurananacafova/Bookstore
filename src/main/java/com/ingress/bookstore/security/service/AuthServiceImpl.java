package com.ingress.bookstore.security.service;

import com.ingress.bookstore.dto.responseDto.AuthorResponseDto;
import com.ingress.bookstore.model.Author;
import com.ingress.bookstore.repository.AuthorRepository;
import com.ingress.bookstore.security.dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public AuthorResponseDto createAuthor(SignUpDto signUpDto) {
        Author author = new Author();
        author.setName(signUpDto.getName());
        author.setAge(signUpDto.getAge());
        author.setMail(signUpDto.getMail());
        author.setPassword(new BCryptPasswordEncoder().encode(signUpDto.getPassword()));
        Author createdStudent = authorRepository.save(author);
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setMail(createdStudent.getMail());
        authorResponseDto.setName(createdStudent.getName());
        authorResponseDto.setAge(createdStudent.getAge());
        return authorResponseDto;
    }

}
