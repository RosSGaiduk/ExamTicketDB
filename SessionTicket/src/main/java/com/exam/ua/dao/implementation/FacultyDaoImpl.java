package com.exam.ua.dao.implementation;

import com.exam.ua.dao.FacultyDao;
import com.exam.ua.entity.Faculty;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Repository
public class FacultyDaoImpl implements FacultyDao {

    @PersistenceContext(name = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(Faculty faculty) {
        entityManager.persist(faculty);
    }

    @Transactional
    public void edit(Faculty faculty) {
        entityManager.merge(faculty);
    }

    @Transactional
    public void delete(Faculty faculty) {
        entityManager.remove(faculty);
    }

    @Transactional
    public Faculty findOne(long id) {
        return entityManager.find(Faculty.class,id);
    }

    @Override
    public Faculty findOneByName(String name) {
        Object o = entityManager.createQuery("select id from Faculty where name like ?1").setParameter(1,name).getSingleResult();
        long id = Integer.parseInt(o.toString());
        return findOne(id);
    }

    @Transactional
    public List<Faculty> findAll() {
        return entityManager.createQuery("from Faculty").getResultList();
    }
}
