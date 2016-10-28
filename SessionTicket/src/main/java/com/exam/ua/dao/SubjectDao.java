package com.exam.ua.dao;

import com.exam.ua.entity.Subject;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface SubjectDao {
    void add(Subject subject);
    void edit(Subject subject);
    void delete(Subject subject);
    Subject findOne(long id);
    Subject findOneByName(String name);
    List<Subject> findAllByGroupId(long groupId);
    List<Subject> findAll();
}
