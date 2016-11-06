package com.exam.ua.validators;

import com.exam.ua.entity.StudentOfLnu;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Rostyslav on 10.10.2016.
 */
@Component
public class StudentValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return StudentOfLnu.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        StudentOfLnu studentOfLnu = (StudentOfLnu)o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.studentEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","lastName.studentEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"course","course.studentEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"form","form.studentEmpty");
        /*ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nameFaculty","nameFaculty.studentEmpty");*/
    }
}
