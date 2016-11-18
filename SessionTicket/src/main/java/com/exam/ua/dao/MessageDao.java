package com.exam.ua.dao;

import com.exam.ua.entity.Message;
import com.sun.xml.internal.ws.api.config.management.ManagedEndpointFactory;

import java.util.List;

/**
 * Created by Rostyslav on 09.11.2016.
 */
public interface MessageDao {
    void add(Message message);
    void edit(Message message);
    void delete(Message message);
    Message findOne(long id);
    long findAllLastBy2ids(long id1,long id2);
    List<Message> findAll();
}
