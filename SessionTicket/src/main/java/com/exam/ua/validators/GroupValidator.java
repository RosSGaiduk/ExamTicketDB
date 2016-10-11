package com.exam.ua.validators;

import com.exam.ua.entity.GroupP;
import com.exam.ua.services.GroupService;
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
public class GroupValidator implements Validator{
    @Autowired
    private GroupService groupService;

    @Override
    public boolean supports(Class<?> aClass) {
        return GroupP.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        GroupP groupp = (GroupP)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.groupempty");
        List<GroupP> groups = groupService.findAll();
        for (GroupP group: groups)
            if (group.getName().equals(groupp.getName())){
                errors.rejectValue("name","groupNameIsAlreadyExists");
            }
    }
}
