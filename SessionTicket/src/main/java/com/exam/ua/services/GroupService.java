package com.exam.ua.services;

import com.exam.ua.entity.GroupP;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public interface GroupService {
    void add(String name);
    void add(GroupP groupP);
    void edit(long id,String name);
    void delete(long id);
    GroupP findOne(long id);
    GroupP findOneByName(String name);
    List<GroupP> findAll();
    List<GroupP> findAllByNameFaculty(String name);
}
