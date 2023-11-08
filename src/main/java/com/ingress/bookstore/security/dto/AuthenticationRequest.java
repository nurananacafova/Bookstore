package com.ingress.bookstore.security.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private  String mail;
    private String password;
}
