package com.ingress.bookstore.dto.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    @Schema(hidden = true)
    private Integer studentId;
    private String name;
    private int age;
    private String mail;
}
