package com.exam.ua.controllers;

import com.exam.ua.entity.Subject;
import com.exam.ua.services.SubjectService;
import com.exam.ua.validators.SubjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rostyslav on 11.10.2016.
 */
@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectValidator subjectValidator;

    @RequestMapping(value = "/allSubjects",method = RequestMethod.GET)
    public String subjectsAllPage(Model model){
        model.addAttribute("subjects",subjectService.findAll());
        return "views-subject-all";
    }

    @RequestMapping(value = "/addSubject",method = RequestMethod.GET)
    public String newSubjectPage(Model model){
        model.addAttribute("subject",new Subject());
        return "views-subject-new";
    }

    @RequestMapping(value = "/createSubject",method = RequestMethod.POST)
    public String createSubject(@ModelAttribute("subject") Subject subject, BindingResult bindingResult){
        subjectValidator.validate(subject,bindingResult);
        if (bindingResult.hasErrors()){
            return "views-subject-new";
        }
        subjectService.add(subject.getName());
        return "redirect:/allSubjects";
    }
}
