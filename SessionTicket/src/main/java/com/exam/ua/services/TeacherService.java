package com.exam.ua.services;

import com.exam.ua.entity.Teacher;

import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface TeacherService {
    void add(String name, String lastName, Date birth, String seat);
    void add(Teacher teacher);
    void edit(long id,String name,String lastName,Date birth,String seat);
    void delete(long id);
    Teacher findOne(long id);
    List<Teacher> findAll();
}
