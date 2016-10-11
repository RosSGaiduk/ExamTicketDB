package com.exam.ua.dao;



import com.exam.ua.entity.StudentOfLnu;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface StudentDao {
    void add(StudentOfLnu studentOfLnu);
    void edit(StudentOfLnu studentOfLnu);
    void delete(StudentOfLnu studentOfLnu);
    StudentOfLnu findOne(long id);
    StudentOfLnu findOne(String query);
    List<StudentOfLnu> findAll();
}
