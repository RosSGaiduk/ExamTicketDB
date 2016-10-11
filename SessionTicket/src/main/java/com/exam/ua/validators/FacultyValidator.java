package com.exam.ua.validators;

import com.exam.ua.entity.Faculty;
import com.exam.ua.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * Created by Rostyslav on 09.10.2016.
 */
@Component
public class FacultyValidator implements Validator{
    @Autowired
    private FacultyService facultyService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Faculty.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Faculty newFaculty = (Faculty)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.empty");
        List<Faculty> faculties = facultyService.findAll();
        boolean wasFaculty = false;
        for (int i = 0; i < faculties.size(); i++){
            if (faculties.get(i).getName().equals(newFaculty.getName())) {
                wasFaculty = true;
                break;
            }
        }
        if (wasFaculty) errors.rejectValue("name","nameIsAlreadyExists");
    }
}
