package com.exam.ua.controllers;

import com.exam.ua.entity.Teacher;
import com.exam.ua.services.FacultyService;
import com.exam.ua.services.TeacherService;
import com.exam.ua.validators.TeacherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Rostyslav on 10.10.2016.
 */
@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private TeacherValidator teacherValidator;

    @RequestMapping(value = "/addTeacher",method = RequestMethod.GET)
    public String newTeacherPage(Model model,Model modelFaculty){
        Teacher teacher = new Teacher();
        model.addAttribute("newTeacher",teacher);
        modelFaculty.addAttribute("faculties",facultyService.findAll());
        return "views-teacher-new";
    }

    @RequestMapping(value = "/createTeacher",method = RequestMethod.POST)
    public String createTeacher(@ModelAttribute("newTeacher") Teacher newTeacher,
                                @RequestParam("facultySelect")String nameFaculty,
                                Model modelFaculty,
                                BindingResult bindingResult
                                ){
        teacherValidator.validate(newTeacher,bindingResult);
        if (bindingResult.hasErrors()){
            modelFaculty.addAttribute("faculties",facultyService.findAll());
            return "views-teacher-new";
        } else {
            newTeacher.setFaculty(facultyService.findOneByName(nameFaculty));
            teacherService.add(newTeacher);
            return "redirect:/";
        }
    }
}
