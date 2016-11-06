package com.exam.ua.dao;

import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.Subject;
import com.exam.ua.entity.Teacher;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface TeacherDao {
    void add(Teacher teacher);
    void addFaculty(Teacher teacher, Faculty faculty);
    void addSubject(Teacher teacher, Subject subject);
    void edit(Teacher teacher);
    void delete(Teacher teacher);
    Teacher findOne(long id);
    List<Teacher> findAll();
}
