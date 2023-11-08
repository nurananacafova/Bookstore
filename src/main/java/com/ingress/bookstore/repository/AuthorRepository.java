package com.ingress.bookstore.repository;


import com.ingress.bookstore.model.Author;
import com.ingress.bookstore.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Optional<Author> findByMail(String mail);

}
