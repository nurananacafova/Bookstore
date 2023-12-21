package com.ingress.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    @Column(name = "id")
    private Integer id;
    private String name;
    private String mail;
    private String password;
    private int age;
    @ManyToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    @ManyToMany(mappedBy = "subscribtion")
    @JsonIgnore
    private List<Student> subscribedStudents = new ArrayList<>();


    public void removeBook(Book book) {
       books.remove(book);
        book.getAuthor().remove(this);
    }


}
