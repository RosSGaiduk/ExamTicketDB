package com.exam.ua.dao;

import com.exam.ua.entity.Faculty;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface FacultyDao {
    void add(Faculty faculty);
    void edit(Faculty faculty);
    void delete(Faculty faculty);
    Faculty findOne(long id);
    Faculty findOneByName(String name);
    List<Faculty> findAll();
}
