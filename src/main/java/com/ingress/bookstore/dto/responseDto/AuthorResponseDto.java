package com.ingress.bookstore.dto.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorResponseDto {
    private Integer authorId;
    private String name;
    private int age;
    private String mail;
    private String password;
    private String bookNames;
    private String subscriptions;
}
