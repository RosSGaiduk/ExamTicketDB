package com.exam.ua.dao;

import com.exam.ua.entity.Subject;
import com.exam.ua.entity.Teacher;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface TeacherDao {
    void add(Teacher teacher);
    void edit(Teacher teacher);
    void delete(Teacher teacher);
    Teacher findOne(long id);
    List<Teacher> findAll();
}
