package com.exam.ua.dao.implementation;

import com.exam.ua.dao.TeacherDao;
import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.Subject;
import com.exam.ua.entity.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Repository
public class TeacherDaoImpl implements TeacherDao{
    @PersistenceContext(name = "Main")
    private EntityManager entityManager;


    @Transactional
    public void add(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Transactional
    public void addFaculty(Teacher teacher, Faculty faculty) {
        entityManager.find(Teacher.class,teacher.getId()).getFaculties().add(faculty);
    }

    @Transactional
    public void addSubject(Teacher teacher, Subject subject) {
        entityManager.find(Teacher.class,teacher.getId()).getSubjects().add(subject);
    }

    @Transactional
    public void edit(Teacher teacher) {
        entityManager.merge(teacher);
    }

    @Transactional
    public void delete(Teacher teacher) {
        entityManager.remove(teacher);
    }

    @Transactional
    public Teacher findOne(long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Transactional
    public List<Teacher> findAll() {
        return entityManager.createQuery("from Teacher").getResultList();
    }
}
