package com.exam.ua.dao.implementation;

import com.exam.ua.dao.UniversityDao;
import com.exam.ua.entity.University;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Rostyslav on 07.11.2016.
 */
@Repository
public class UniversityDaoImpl implements UniversityDao {
    @PersistenceContext(name = "Main")
    private EntityManager entityManager;


    @Transactional
    public University findOne(long id) {
        return entityManager.find(University.class,id);
    }
}
