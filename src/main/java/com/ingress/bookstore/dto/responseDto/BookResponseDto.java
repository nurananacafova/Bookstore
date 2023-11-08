package com.ingress.bookstore.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ingress.bookstore.model.Author;
import com.ingress.bookstore.model.Book;
import lombok.*;




@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private Integer bookId;
    private String name;
    private String authorNames;
    @JsonIgnore
    private int authorId;
}
