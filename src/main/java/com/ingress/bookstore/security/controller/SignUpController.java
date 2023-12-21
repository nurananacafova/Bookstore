package com.ingress.bookstore.security.controller;

import com.ingress.bookstore.dto.responseDto.AuthorResponseDto;
import com.ingress.bookstore.security.dto.SignUpDto;
import com.ingress.bookstore.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Autowired
    private AuthService authService;
    @PostMapping("/api/bookstore/author/register")
    public ResponseEntity<?> createUser(@RequestBody SignUpDto signUpRequest){
        AuthorResponseDto createdAuthor= authService.createAuthor(signUpRequest);
        if (createdAuthor==null){
            return new ResponseEntity<>("User not created,try again", HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(createdAuthor,HttpStatus.CREATED);
    }

}
