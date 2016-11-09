package com.exam.ua.dao.implementation;

import com.exam.ua.dao.MessageDao;
import com.exam.ua.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Rostyslav on 09.11.2016.
 */
@Repository
public class MessageDaoImpl implements MessageDao {

    @PersistenceContext(name = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(Message message) {
        entityManager.persist(message);
    }

    @Transactional
    public void edit(Message message) {
        entityManager.merge(message);
    }

    @Transactional
    public void delete(Message message) {
        entityManager.remove(message);
    }

    @Transactional
    public Message findOne(long id) {
        return entityManager.find(Message.class,id);
    }

    @Transactional
    public List<Message> findAll() {
        return entityManager.createQuery("from Message").getResultList();
    }
}

