package com.ingress.bookstore.security.service;

import com.ingress.bookstore.dto.responseDto.AuthorResponseDto;
import com.ingress.bookstore.security.dto.SignUpDto;

public interface AuthService {
    AuthorResponseDto createAuthor(SignUpDto signUpDto);
}
