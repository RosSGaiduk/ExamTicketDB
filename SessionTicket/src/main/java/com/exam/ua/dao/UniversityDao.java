package com.exam.ua.dao;

import com.exam.ua.entity.University;

/**
 * Created by Rostyslav on 07.11.2016.
 */
public interface UniversityDao {
    University findOne(long id);
}
