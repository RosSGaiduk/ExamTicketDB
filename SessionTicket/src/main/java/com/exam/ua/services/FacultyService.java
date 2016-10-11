package com.exam.ua.services;

import com.exam.ua.entity.Faculty;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface FacultyService {
    void add(String name);
    void add(Faculty faculty);
    void edit(long id,String name,String urlOfImage);
    void delete(long id);
    Faculty findOne(long id);
    Faculty findOneByName(String name);
    List<Faculty> findAll();
}
