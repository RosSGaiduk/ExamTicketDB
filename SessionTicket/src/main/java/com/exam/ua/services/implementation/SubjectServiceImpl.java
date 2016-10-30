package com.exam.ua.services.implementation;

import com.exam.ua.dao.SubjectDao;
import com.exam.ua.entity.Subject;
import com.exam.ua.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public void add(String name) {
        subjectDao.add(new Subject(name));
    }

    @Override
    public void add(Subject subject) {
        subjectDao.add(subject);
    }

    @Override
    public void edit(long id, String name) {
        Subject subject = subjectDao.findOne(id);
        subject.setName(name);
        subjectDao.edit(subject);
    }

    @Override
    public void delete(long id) {
        subjectDao.delete(subjectDao.findOne(id));
    }

    @Override
    public Subject findOne(long id) {
        return subjectDao.findOne(id);
    }

    @Override
    public Subject findOneByName(String name) {
        return subjectDao.findOneByName(name);
    }

    @Override
    public List<Subject> findAllByGroupId(long groupId) {
        return subjectDao.findAllByGroupId(groupId);
    }

    @Override
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }
}
