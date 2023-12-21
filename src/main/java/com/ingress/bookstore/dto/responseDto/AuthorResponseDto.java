package com.ingress.bookstore.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String bookNames;
    @JsonIgnore
    private String subscriptions;
}
