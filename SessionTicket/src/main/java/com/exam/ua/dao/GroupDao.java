package com.exam.ua.dao;


import com.exam.ua.entity.GroupP;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface GroupDao {
    void add(GroupP groupP);
    void edit(GroupP groupP);
    void delete(GroupP groupP);
    GroupP findOne(long id);
    GroupP findOneByName(String name);
    List<GroupP> findAllByNamefaculty(String name);
    List<GroupP> findAll();
}
