package com.exam.ua.services;

import com.exam.ua.entity.Message;
import com.exam.ua.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 09.11.2016.
 */
public interface MessageService {
    void add(Message message);
    void add(User userFrom, User userTo, String text, Date dateOfMessage);
    void edit(long id);
    void delete(long id);
    Message findOne(long id);
    List<Message> findAll();
}
