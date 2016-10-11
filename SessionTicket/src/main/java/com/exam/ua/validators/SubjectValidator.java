package com.exam.ua.validators;

import com.exam.ua.entity.Subject;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Rostyslav on 11.10.2016.
 */
@Component
public class SubjectValidator implements Validator{


    @Override
    public boolean supports(Class<?> aClass) {
        return Subject.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.subjectEmpty");
    }
}
