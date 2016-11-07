package com.exam.ua.dao;

import com.exam.ua.entity.Writer;

import java.util.List;

/**
 * Created by Rostyslav on 07.11.2016.
 */
public interface WriterDao {
    void add(Writer writer);
    void edit(Writer writer);
    void delete(Writer writer);
    Writer findOne(long id);
    List<Writer> findAll();
}
