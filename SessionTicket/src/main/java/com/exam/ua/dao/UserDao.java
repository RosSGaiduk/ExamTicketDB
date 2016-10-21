package com.exam.ua.dao;

import com.exam.ua.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 21.10.2016.
 */
public interface UserDao {
    void add(User user);
    void delete(User user);
    void edit(User user);
    User findOne(long id);
    List<User> findAll();
}
