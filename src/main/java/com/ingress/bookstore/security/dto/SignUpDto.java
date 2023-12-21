package com.ingress.bookstore.security.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpDto {
    private String name;
    private int age;
    private String mail;
    private String password;
}
