package com.ingress.bookstore.service;

import com.ingress.bookstore.model.MailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;
//    @Value("$(spring.mail.username)")
    private String fromMail="newmailfortests1@gmail.com";

    public void sendMail(String mail, MailModel mailModel) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setSubject(mailModel.getSubject());
        message.setText(mailModel.getMessage());
        message.setTo(mail);
        mailSender.send(message);
    }
}

