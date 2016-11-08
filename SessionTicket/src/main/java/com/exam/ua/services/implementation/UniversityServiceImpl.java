package com.exam.ua.services.implementation;

import com.exam.ua.dao.UniversityDao;
import com.exam.ua.entity.University;
import com.exam.ua.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Rostyslav on 07.11.2016.
 */
@Service
public class UniversityServiceImpl implements UniversityService{

    @Autowired
    private UniversityDao universityDao;

    @Override
    public University findOne(long id) {
        return universityDao.findOne(id);
    }
}
