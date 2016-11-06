package com.exam.ua.controllers;

import com.exam.ua.entity.Subject;
import com.exam.ua.entity.Teacher;
import com.exam.ua.services.FacultyService;
import com.exam.ua.services.SubjectService;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 10.10.2016.
 */
@Controller
public class TeacherController extends BaseMethods{
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TeacherValidator teacherValidator;

    @RequestMapping(value = "/addTeacher",method = RequestMethod.GET)
    public String newTeacherPage(Model model,Model modelFaculty,Model modelSubject){
        Teacher teacher = new Teacher();
        model.addAttribute("newTeacher",teacher);
        modelFaculty.addAttribute("faculties",facultyService.findAll());
        modelSubject.addAttribute("subjects",subjectService.findAll());
        return "views-teacher-new";
    }

    @RequestMapping(value = "/createTeacher",method = RequestMethod.POST)
    public String createTeacher(@ModelAttribute("newTeacher") Teacher newTeacher,
                                @RequestParam("birthDate")String date,
                                @RequestParam("facultySelect")String nameFaculty,
                                @RequestParam("subjectSelect")String nameSubject,
                                Model modelFaculty,Model modelSubject,
                                BindingResult bindingResult
                                ){
       DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birth = formatter.parse(date);
            newTeacher.setBirth(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newTeacher.setName(stringUTF_8Encode(newTeacher.getName()));
        newTeacher.setLastName(stringUTF_8Encode(newTeacher.getLastName()));
        newTeacher.setSeat(stringUTF_8Encode(newTeacher.getSeat()));
        nameFaculty = stringUTF_8Encode(nameFaculty);
        nameSubject = stringUTF_8Encode(nameSubject);

        teacherValidator.validate(newTeacher,bindingResult);

        if (bindingResult.hasErrors()){
            modelFaculty.addAttribute("faculties",facultyService.findAll());
            modelSubject.addAttribute("subjects",subjectService.findAll());
            return "views-teacher-new";
        } else {
            newTeacher.setFaculty(facultyService.findOneByName(nameFaculty));
            newTeacher.getSubjects().add(subjectService.findOneByName(nameSubject));
            teacherService.add(newTeacher);
            return "redirect:/";
        }
    }
    @RequestMapping(value = "/allTeachers",method = RequestMethod.GET)
    public String allTeachersPage(Model model){
        List<Teacher> teacherList = teacherService.findAll();
        model.addAttribute("teachers",teacherList);
        return "views-teacher-all";
    }
}
