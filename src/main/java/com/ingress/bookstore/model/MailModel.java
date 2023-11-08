package com.ingress.bookstore.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailModel {
    private String to;
    private String subject;
    private String message;
//    public String to;
//    public String from;
//    public String password;
//    public String content;
}
