package com.exam.ua.services;

import com.exam.ua.entity.ExamForGroup;
import com.exam.ua.entity.SessionOfGroup;

import java.util.List;
import java.util.Set;

/**
 * Created by Rostyslav on 01.11.2016.
 */
public interface SessionGroupService {
    void add(SessionOfGroup session);
    void add(List<ExamForGroup> exams);
    void delete(long id);
    void edit(long id);
    SessionOfGroup findOne(long id);
    List<SessionOfGroup> findAll();
}
