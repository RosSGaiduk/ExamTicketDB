package com.exam.ua.services.implementation;

import com.exam.ua.dao.TeacherDao;
import com.exam.ua.entity.Teacher;
import com.exam.ua.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;


    @Override
    public void add(String name, String lastName, int age, String seat) {
        teacherDao.add(new Teacher(name,lastName,age,seat));
    }

    @Override
    public void add(Teacher teacher) {
        teacherDao.add(teacher);
    }

    @Override
    public void edit(long id, String name, String lastName, int age, String seat) {
        Teacher teacher = teacherDao.findOne(id);
        teacher.setName(name); teacher.setLastName(lastName); teacher.setAge(age); teacher.setSeat(seat);
        teacherDao.edit(teacher);
    }

    @Override
    public void delete(long id) {
        teacherDao.delete(teacherDao.findOne(id));
    }

    @Override
    public Teacher findOne(long id) {
        return teacherDao.findOne(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }
}
