package com.exam.ua.services.implementation;

import com.exam.ua.dao.MessageDao;
import com.exam.ua.entity.Message;
import com.exam.ua.entity.User;
import com.exam.ua.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 09.11.2016.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public void add(Message message) {
        messageDao.add(message);
    }

    @Override
    public void add(User userFrom, User userTo, String text, Date dateOfMessage) {
        Message message = new Message(userFrom,userTo,text,dateOfMessage);
        messageDao.add(message);
    }

    @Override
    public void edit(long id) {
        Message message = findOne(id);
        messageDao.edit(message);
    }

    @Override
    public void delete(long id) {
        messageDao.delete(findOne(id));
    }

    @Override
    public Message findOne(long id) {
        return messageDao.findOne(id);
    }

    @Override
    public long findAllLastBy2ids(long id1, long id2) {
        return messageDao.findAllLastBy2ids(id1,id2);
    }

    @Override
    public long findAllById(long id1) {
        return messageDao.findAllById(id1);
    }

    @Override
    public List<Message> findAll() {
        return messageDao.findAll();
    }
}
