package com.exam.ua.dao.implementation;

import com.exam.ua.dao.GroupDao;
import com.exam.ua.entity.GroupP;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Repository
public class GroupDaoImpl implements GroupDao{

    @PersistenceContext(name = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(GroupP groupP) {
        entityManager.persist(groupP);
    }

    @Transactional
    public void edit(GroupP groupP) {
        entityManager.merge(groupP);
    }

    @Transactional
    public void delete(GroupP groupP) {
        entityManager.remove(groupP);
    }

    @Transactional
    public GroupP findOne(long id) {
        return entityManager.find(GroupP.class,id);
    }

    @Transactional
    public List<GroupP>findAllByNamefaculty(String name) {
        List<GroupP> groupPs = entityManager.createQuery("FROM GroupP where nameFacultyPattern like ?1").setParameter(1,name).getResultList();
        return groupPs;
    }

    @Transactional
    public List<GroupP> findAll() {
        return entityManager.createQuery("from GroupP").getResultList();
    }
}
