package com.exam.ua.services.implementation;

import com.exam.ua.dao.ExamDao;
import com.exam.ua.entity.ExamForGroup;
import com.exam.ua.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 11.10.2016.
 */
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;

    @Override
    public void add(Date date, int hour, int minute) {
        ExamForGroup examForGroup = new ExamForGroup(date,hour,minute);
        examDao.add(examForGroup);
    }

    @Override
    public void add(ExamForGroup examForGroup) {
        examDao.add(examForGroup);
    }

    @Override
    public void edit(long id, Date date) {
        ExamForGroup examForGroup = examDao.findOne(id);
        examForGroup.setDate(date);
        examDao.edit(examForGroup);
    }

    @Override
    public void edit(ExamForGroup examForGroup) {
        examDao.edit(examForGroup);
    }

    @Override
    public void delete(long id) {
        examDao.delete(examDao.findOne(id));
    }

    @Override
    public ExamForGroup findOne(long id) {
        return examDao.findOne(id);
    }

    @Override
    public List<ExamForGroup> findAll() {
        return examDao.findAll();
    }

    @Override
    public List<ExamForGroup> findAllByFacultyId(long id) {
        return examDao.findAllByFacultyId(id);
    }
}
