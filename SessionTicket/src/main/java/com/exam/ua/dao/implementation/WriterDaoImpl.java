package com.exam.ua.dao.implementation;

import com.exam.ua.dao.WriterDao;
import com.exam.ua.entity.Writer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Rostyslav on 07.11.2016.
 */
@Repository
public class WriterDaoImpl implements WriterDao{

    @PersistenceContext(name = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(Writer writer) {
        entityManager.persist(writer);
    }

    @Transactional
    public void edit(Writer writer) {
        entityManager.merge(writer);
    }

    @Transactional
    public void delete(Writer writer) {
        entityManager.remove(writer);
    }

    @Transactional
    public Writer findOne(long id) {
        return entityManager.find(Writer.class,id);
    }

    @Transactional
    public List<Writer> findAll() {
        return entityManager.createQuery("from Writer").getResultList();
    }
}
