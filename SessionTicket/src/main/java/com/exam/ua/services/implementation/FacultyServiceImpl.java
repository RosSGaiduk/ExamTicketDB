package com.exam.ua.services.implementation;

import com.exam.ua.dao.FacultyDao;
import com.exam.ua.entity.Faculty;
import com.exam.ua.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyDao facultyDao;

    @Override
    public void add(String name) {
        Faculty faculty = new Faculty(name);
        facultyDao.add(faculty);
    }

    @Override
    public void add(Faculty faculty) {
        facultyDao.add(faculty);
    }

    @Override
    public void edit(long id, String name, String urlOfImage) {
        Faculty faculty = facultyDao.findOne(id);
        faculty.setName(name); faculty.setUrlImage(urlOfImage);
        facultyDao.edit(faculty);
    }

    @Override
    public void delete(long id) {
        facultyDao.delete(facultyDao.findOne(id));
    }

    @Override
    public Faculty findOne(long id) {
        return facultyDao.findOne(id);
    }

    @Override
    public Faculty findOneByName(String name) {
        return facultyDao.findOneByName(name);
    }

    @Override
    public List<Faculty> findAll() {
        return facultyDao.findAll();
    }
}
