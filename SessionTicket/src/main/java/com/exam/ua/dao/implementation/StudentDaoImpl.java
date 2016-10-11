package com.exam.ua.dao.implementation;

import com.exam.ua.dao.StudentDao;
import com.exam.ua.entity.StudentOfLnu;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Repository
public class StudentDaoImpl implements StudentDao{

    @PersistenceContext(name = "Main")
    private EntityManager entityManager;
    @Transactional
    public void add(StudentOfLnu studentOfLnu) {
        entityManager.persist(studentOfLnu);
    }

    @Transactional
    public void edit(StudentOfLnu studentOfLnu) {
        entityManager.merge(studentOfLnu);
    }

    @Transactional
    public void delete(StudentOfLnu studentOfLnu) {
        entityManager.remove(studentOfLnu);
    }

    @Transactional
    public StudentOfLnu findOne(long id) {
        return entityManager.find(StudentOfLnu.class,id);
    }

    @Transactional
    public StudentOfLnu findOne(String query) {
        Object o = entityManager.createQuery(query).getSingleResult();
        long i = Integer.parseInt(o.toString());
        return findOne(i);
    }

    @Transactional
    public List<StudentOfLnu> findAll() {
        return entityManager.createQuery("from StudentOfLnu").getResultList();
    }
}
