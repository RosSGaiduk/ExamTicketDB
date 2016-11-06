package com.exam.ua.services;

import com.exam.ua.entity.StudentOfLnu;

import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface StudentService {
    void add(String name, String lastName, Date birth, int course, String form, String facultyName);
    void add(StudentOfLnu studentOfLnu);
    void edit(long id,String name,String lastName,Date birth,int course,String form);
    void edit(StudentOfLnu studentOfLnu);
    void delete(long id);
    StudentOfLnu findOne(long id);
    StudentOfLnu findOne(String guery);
    List<StudentOfLnu> findAll();
}
