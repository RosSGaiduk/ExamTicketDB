package com.exam.ua.dao;

import com.exam.ua.entity.SessionOfGroup;

import java.util.List;
import java.util.Set;

/**
 * Created by Rostyslav on 01.11.2016.
 */
public interface SessionGroupDao {
    void add(SessionOfGroup session);
    void edit(SessionOfGroup session);
    void delete(long id);
    SessionOfGroup findOne(long id);
    List<SessionOfGroup> findAll();
    List<SessionOfGroup> findAllByFacultyId(long facultyId);
}
