package com.exam.ua.services;

import com.exam.ua.entity.ExamForGroup;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 11.10.2016.
 */
public interface ExamService {
    void add(Date date, Time time);
    void add(ExamForGroup examForGroup);
    void edit(long id,Date date);
    void edit(ExamForGroup examForGroup);
    void delete(long id);
    ExamForGroup findOne(long id);
    List<ExamForGroup> findAll();
    List<ExamForGroup> findAllByFacultyId(long id);
    List<ExamForGroup> findAllByGroupId(long id);
}
