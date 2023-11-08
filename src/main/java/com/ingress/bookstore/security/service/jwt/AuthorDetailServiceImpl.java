package com.ingress.bookstore.security.service.jwt;

import com.ingress.bookstore.model.Student;
import com.ingress.bookstore.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthorDetailServiceImpl implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<Student> student=studentRepository.findByMail(mail);
        if (student==null){
            throw  new UsernameNotFoundException("User not found",null);
        }
        return new User(student.get().getMail(),student.get().getPassword(),new ArrayList<>());
    }

}
