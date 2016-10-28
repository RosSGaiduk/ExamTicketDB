package com.exam.ua.dao.implementation;

import com.exam.ua.dao.SubjectDao;
import com.exam.ua.entity.Subject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Repository
public class SubjectDaoImpl implements SubjectDao{
    @PersistenceContext(name = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(Subject subject) {
        entityManager.persist(subject);
    }

    @Transactional
    public void edit(Subject subject) {
        entityManager.merge(subject);
    }

    @Transactional
    public void delete(Subject subject) {
        entityManager.remove(subject);
    }

    @Transactional
    public Subject findOne(long id) {
        return entityManager.find(Subject.class,id);
    }

    @Transactional
    public Subject findOneByName(String name) {
        Object o = entityManager.createQuery("select id from Subject where name like ?1").setParameter(1,name).getSingleResult();
        long id = Integer.parseInt(o.toString());
        return findOne(id);
    }
    //Цей метод не працює
    @Transactional
    public List<Subject> findAllByGroupId(long groupId) {
        List<Long> idSubjects = entityManager.createQuery("select id_subject from group_subject where id_group like ?1").setParameter(1,groupId).getResultList();
        List<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < idSubjects.size(); i++){
            subjects.add(findOne(idSubjects.get(i)));
        }
        return subjects;
    }


    @Transactional
    public List<Subject> findAll() {
        return entityManager.createQuery("from Subject").getResultList();
    }
}
