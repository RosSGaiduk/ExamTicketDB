package com.exam.ua.services;

import com.exam.ua.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 21.10.2016.
 */
public interface UserService {
    void add(String firstName, String lastName, Date birthDate, String email,String password);
    void add(User user);
    void delete(long id);
    void edit(long id,String firstName, String lastName, Date birthDate, String email,String password);
    void edit(User user);
    User findOne(long id);
    List<User> findAll();
}
