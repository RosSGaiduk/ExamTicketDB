package com.exam.ua.validators;

import com.exam.ua.entity.User;
import com.exam.ua.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Rostyslav on 31.10.2016.
 */
@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","firstName.userEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","lastName.userEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","email.userEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","password.userEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"birthDate","birthDate.userEmpty");

        User user = (User)o;
        if (!(user.getPassword().equals(user.getConfirmPassword()))){
            errors.rejectValue("password","password.userNotSameConfirmPassword");
        }

    }
}
