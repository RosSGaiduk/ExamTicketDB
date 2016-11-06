package com.exam.ua.validators;

import com.exam.ua.entity.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Rostyslav on 10.10.2016.
 */
@Component
public class TeacherValidator implements Validator{


    @Override
    public boolean supports(Class<?> aClass) {
        return Teacher.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.teacherEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","lastName.teacherEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"seat","seat.teacherEmpty");
    }
}
