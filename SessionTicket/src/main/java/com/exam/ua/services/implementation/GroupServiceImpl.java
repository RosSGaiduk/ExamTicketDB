package com.exam.ua.services.implementation;

import com.exam.ua.dao.GroupDao;
import com.exam.ua.entity.GroupP;
import com.exam.ua.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    private GroupDao groupDao;

    @Override
    public void add(String name) {
        groupDao.add(new GroupP(name));
    }

    @Override
    public void add(GroupP groupP) {
        groupDao.add(groupP);
    }

    @Override
    public void edit(long id, String name) {
        GroupP groupP = groupDao.findOne(id);
        groupP.setName(name);
        groupDao.edit(groupP);
    }

    @Override
    public void delete(long id) {
        groupDao.delete(groupDao.findOne(id));
    }

    @Override
    public GroupP findOne(long id) {
        return groupDao.findOne(id);
    }

    @Override
    public List<GroupP> findAll() {
        return groupDao.findAll();
    }
}
