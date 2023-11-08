package com.ingress.bookstore.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {
    private String name;
    private String mail;
    private String password;
    private int age;
}
