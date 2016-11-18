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
    public long findAllLastBy2ids(long id1,long id2) {
        //return entityManager.createQuery("from Message where (user_id = ?1 and userTo_id = ?2) or (userTo_id = ?1 and user_id = ?2) order by id ASC limit ?3").setParameter(1,id1).setParameter(2,id2).setParameter(3,count).getResultList();

        Object count = entityManager.createQuery("select count(id) from Message where (user_id = ?1 and userTo_id = ?2) or (userTo_id = ?1 and user_id = ?2) order by id desc").setParameter(1,1).setParameter(2,2).getSingleResult();
    return (long) count;
    }

    @Transactional
    public long findAllById(long id1) {
        Object count = entityManager.createQuery("select count(id) from Message where user_id = ?1 or userTo_id = ?1").setParameter(1,id1).getSingleResult();
        return (long) count;
    }

    @Transactional
    public List<Message> findAll() {

        return entityManager.createQuery("from Message").getResultList();
    }
}

