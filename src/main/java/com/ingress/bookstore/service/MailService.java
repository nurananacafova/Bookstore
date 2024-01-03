package com.ingress.bookstore.service;

import com.ingress.bookstore.model.MailModel;

public interface MailService{
    void sendMail(String mail, MailModel mailModel);
}
