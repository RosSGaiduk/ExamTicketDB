package com.exam.ua.dao.implementation;

import com.exam.ua.dao.ExamDao;
import com.exam.ua.entity.ExamForGroup;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Rostyslav on 11.10.2016.
 */
@Repository
public class ExamDaoImpl implements ExamDao{

    @PersistenceContext(name = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(ExamForGroup examForGroup) {
        entityManager.persist(examForGroup);
    }

    @Transactional
    public void edit(ExamForGroup examForGroup) {
        entityManager.merge(examForGroup);
    }

    @Transactional
    public void delete(ExamForGroup examForGroup) {
        entityManager.remove(examForGroup);
    }

    @Transactional
    public ExamForGroup findOne(long id) {
        return entityManager.find(ExamForGroup.class,id);
    }

    @Transactional
    public List<ExamForGroup> findAll() {
        return entityManager.createQuery("from ExamForGroup").getResultList();
    }

    @Transactional
    public List<ExamForGroup> findAllByFacultyId(long id) {
        return entityManager.createQuery("from ExamForGroup where faculty_id like ?1").setParameter(1,id).getResultList();
    }
    @Transactional
    public List<ExamForGroup> findAllByGroupId(long id) {
        return entityManager.createQuery("from ExamForGroup where groupP_id like ?1").setParameter(1,id).getResultList();
    }
}
