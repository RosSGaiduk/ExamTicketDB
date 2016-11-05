package com.exam.ua.controllers;

import com.exam.ua.entity.Faculty;
import com.exam.ua.services.FacultyService;
import com.exam.ua.validators.FacultyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;


/**
 * Created by Rostyslav on 09.10.2016.
 */
@Controller
public class FacultyController extends BaseMethods{
    @Autowired
    private FacultyService facultyService;

    @Autowired
    private FacultyValidator facultyValidator;
    //по цій ссилці ми переходимо на сторінку де буде spring - форма, тому нам потрібно передати об'єкт
    @RequestMapping(value = "/addFaculty",method = RequestMethod.GET)
    public String newFacultyPage(Model model){
        model.addAttribute("newFaculty",new Faculty());
        return "views-faculty-new";
    }

    @RequestMapping(value = "/createFaculty",method = RequestMethod.POST)
    public String createFaculty(@ModelAttribute("newFaculty") Faculty newFaculty, BindingResult bindingResult){

        newFaculty.setName(stringUTF_8Encode(newFaculty.getName()));
        facultyValidator.validate(newFaculty,bindingResult);
        if (bindingResult.hasErrors()){
            return "views-faculty-new";
        } else {
            facultyService.add(newFaculty);
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/allFaculties",method = RequestMethod.GET)
    public String allfaculties(Model model){
        model.addAttribute("faculties",facultyService.findAll());
        return "views-faculty-all";
    }
}
