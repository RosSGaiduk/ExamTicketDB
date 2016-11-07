package com.exam.ua.services.implementation;

import com.exam.ua.dao.WriterDao;
import com.exam.ua.entity.Writer;
import com.exam.ua.services.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rostyslav on 07.11.2016.
 */
@Service
public class WriterServiceImpl implements WriterService {
    @Autowired
    private WriterDao writerDao;

    @Override
    public void add(Writer writer) {
        writerDao.add(writer);
    }

    @Override
    public void add(String lastName, String name, String fatherName, String biography) {
        Writer writer = new Writer(lastName,name,fatherName,biography);
        writerDao.add(writer);
    }

    @Override
    public void edit(long id) {
        writerDao.edit(findOne(id));
    }

    @Override
    public void delete(long id) {
        writerDao.delete(findOne(id));
    }

    @Override
    public Writer findOne(long id) {
        return writerDao.findOne(id);
    }

    @Override
    public List<Writer> findAll() {
        return writerDao.findAll();
    }
}
