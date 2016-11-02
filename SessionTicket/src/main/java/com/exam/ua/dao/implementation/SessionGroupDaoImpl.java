package com.exam.ua.dao.implementation;

import com.exam.ua.dao.SessionGroupDao;
import com.exam.ua.entity.SessionOfGroup;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostyslav on 01.11.2016.
 */
@Repository
public class SessionGroupDaoImpl implements SessionGroupDao {
    @PersistenceContext(name = "Main")
    private EntityManager entityManager;


    @Transactional
    public void add(SessionOfGroup session) {
        entityManager.merge(session);
    }

    @Transactional
    public void edit(SessionOfGroup session) {
        entityManager.merge(session);
    }

    @Transactional
    public void delete(long id) {
        entityManager.remove(findOne(id));
    }

    @Transactional
    public SessionOfGroup findOne(long id) {
        return entityManager.find(SessionOfGroup.class,id);
    }

    @Transactional
    public List<SessionOfGroup> findAll() {
        return entityManager.createQuery("from SessionOfGroup").getResultList();
    }
}
