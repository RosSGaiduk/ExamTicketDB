package com.exam.ua.services;



import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.Subject;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface SubjectService {
    void add(String name);
    void add(Subject subject);
    void edit(long id,String name);
    void edit(Subject subject);
    void addFacultyToSubject(Subject subject, Faculty faculty);
    void delete(long id);
    Subject findOne(long id);
    Subject findOneByName(String name);
    List<Subject> findAllByGroupId(long groupId);
    List<Subject> findAll();
}
