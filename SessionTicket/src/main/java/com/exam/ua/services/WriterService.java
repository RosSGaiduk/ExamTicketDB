package com.exam.ua.services;

import com.exam.ua.entity.Writer;

import java.util.List;

/**
 * Created by Rostyslav on 07.11.2016.
 */
public interface WriterService {
    void add(Writer writer);
    void add(String lastName, String name, String fatherName, String biography);
    void edit(long id);
    void delete(long id);
    Writer findOne(long id);
    List<Writer> findAll();
}
