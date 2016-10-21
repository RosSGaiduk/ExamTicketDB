package com.exam.ua.dao.implementation;

import com.exam.ua.dao.UserDao;
import com.exam.ua.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Rostyslav on 21.10.2016.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext(name = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Transactional
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Transactional
    public User findOne(long id) {
        return entityManager.find(User.class,id);
    }

    @Transactional
    public List<User> findAll() {
        return entityManager.createQuery("from User").getResultList();
    }
}
