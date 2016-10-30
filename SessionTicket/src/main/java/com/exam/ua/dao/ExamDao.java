package com.exam.ua.dao;

import com.exam.ua.entity.ExamForGroup;

import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 11.10.2016.
 */
public interface ExamDao {
    void add(ExamForGroup examForGroup);
    void edit(ExamForGroup examForGroup);
    void delete(ExamForGroup examForGroup);
    ExamForGroup findOne(long id);
    List<ExamForGroup> findAll();
    List<ExamForGroup> findAllByFacultyId(long id);
}
