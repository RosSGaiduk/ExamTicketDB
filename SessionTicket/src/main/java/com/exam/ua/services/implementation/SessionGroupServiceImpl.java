package com.exam.ua.services.implementation;

import com.exam.ua.dao.SessionGroupDao;
import com.exam.ua.services.SessionGroupService;
import com.exam.ua.entity.ExamForGroup;
import com.exam.ua.entity.SessionOfGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Rostyslav on 01.11.2016.
 */
@Service
public class SessionGroupServiceImpl implements SessionGroupService {
    @Autowired
    private SessionGroupDao sessionDao;

    @Override
    public void add(SessionOfGroup session) {
        sessionDao.add(session);
    }

    @Override
    public void add(List<ExamForGroup> exams) {
        sessionDao.add(new SessionOfGroup(exams));
    }

    @Override
    public void delete(long id) {
        sessionDao.delete(id);
    }

    @Override
    public void edit(long id) {
        sessionDao.edit(findOne(id));
    }

    @Override
    public SessionOfGroup findOne(long id) {
        return sessionDao.findOne(id);
    }

    @Override
    public List<SessionOfGroup> findAll() {
        return sessionDao.findAll();
    }

    @Override
    public List<SessionOfGroup> findAllByFacultyId(long facultyId) {
        return sessionDao.findAllByFacultyId(facultyId);
    }
}
