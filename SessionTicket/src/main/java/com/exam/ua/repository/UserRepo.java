package com.exam.ua.repository;

import com.exam.ua.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Rostyslav on 08.11.2016.
 */
public interface UserRepo extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.email LIKE :login")
    User findByLogin(@Param("login") String login);
}
