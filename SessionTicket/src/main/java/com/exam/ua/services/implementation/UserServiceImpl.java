package com.exam.ua.services.implementation;

import com.exam.ua.dao.UserDao;
import com.exam.ua.entity.User;
import com.exam.ua.repository.UserRepo;
import com.exam.ua.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 21.10.2016.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void add(String firstName, String lastName, Date birthDate, String email, String password) {
        User user = new User();
        user.setFirstName(firstName); user.setLastName(lastName); user.setBirthDate(birthDate); user.setEmail(email);
        user.setPassword(password);
        userDao.add(user);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(userDao.findOne(id));
    }

    @Override
    public void edit(long id, String firstName, String lastName, Date birthDate, String email, String password) {
        User user = userDao.findOne(id);
        user.setFirstName(firstName); user.setLastName(lastName); user.setBirthDate(birthDate); user.setEmail(email);
        user.setPassword(password);
        userDao.edit(user);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public User findOne(long id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user;
        try {
            user = userRepo.findByLogin(login);
            System.out.println(user.getFirstName());
        } catch (NoResultException e){
            System.out.println("No result");
            return  null;
        }


        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()),user.getPassword(),authorities);
        return user1;
    }

}
