package com.exam.ua.services.implementation;

import com.exam.ua.dao.StudentDao;
import com.exam.ua.entity.StudentOfLnu;
import com.exam.ua.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;

    @Override
    public void add(String name, String lastName, int age, int course, String form,String facultyName) {
        studentDao.add(new StudentOfLnu(name,lastName,age,course,form,facultyName));
    }


    @Override
    public void add(StudentOfLnu studentOfLnu) {
        studentDao.add(studentOfLnu);
    }

    @Override
    public void edit(long id, String name, String lastName, int age, int course, String form) {
        StudentOfLnu student = studentDao.findOne(id);
        student.setName(name); student.setLastName(lastName); student.setAge(age); student.setCourse(course);
        student.setForm(form);
        studentDao.edit(student);
    }

    @Override
    public void edit(StudentOfLnu studentOfLnu) {
        studentDao.edit(studentOfLnu);
    }

    @Override
    public void delete(long id) {
        studentDao.delete(studentDao.findOne(id));
    }

    @Override
    public StudentOfLnu findOne(long id) {
        return studentDao.findOne(id);
    }

    @Override
    public StudentOfLnu findOne(String guery) {
        return studentDao.findOne(guery);
    }

    @Override
    public List<StudentOfLnu> findAll() {
        return studentDao.findAll();
    }
}
