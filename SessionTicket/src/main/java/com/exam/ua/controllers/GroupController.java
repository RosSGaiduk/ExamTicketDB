package com.exam.ua.controllers;

import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.GroupP;
import com.exam.ua.entity.Subject;
import com.exam.ua.services.FacultyService;
import com.exam.ua.services.GroupService;
import com.exam.ua.services.SubjectService;
import com.exam.ua.validators.GroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostyslav on 09.10.2016.
 */
@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private GroupValidator groupValidator;


    @RequestMapping(value = "/addGroup",method = RequestMethod.GET)
    public String newGroupPage(Model model,Model modelFaculties,Model modelSubjects){
        List<Faculty> faculties = facultyService.findAll();
        modelFaculties.addAttribute("faculties",faculties);
        modelFaculties.addAttribute("subjects",subjectService.findAll());
        model.addAttribute("grouppP",new GroupP());
        return "views-group-new";
    }

    @RequestMapping(value = "/createGroup",method = RequestMethod.POST)
    public String createGroup(@ModelAttribute("grouppP") GroupP grouppP,
                                @RequestParam("facultySelect")String facultyName,
                                @RequestParam("groupSubject1")String subject1,
                                @RequestParam("groupSubject2")String subject2,
                                @RequestParam("groupSubject3")String subject3,
                                @RequestParam("groupSubject4")String subject4,
                                    Model modelFaculties,Model modelSubjects,
                                        BindingResult bindingResult
                                            ){
        groupValidator.validate(grouppP,bindingResult);
        if (bindingResult.hasErrors()){
            modelFaculties.addAttribute("faculties",facultyService.findAll());
            modelSubjects.addAttribute("subjects",subjectService.findAll());
            return "views-group-new";
        }
        else {
            List<Subject> subjects = new ArrayList<>();
                subjects.add(subjectService.findOneByName(subject1));
                subjects.add(subjectService.findOneByName(subject2));
                subjects.add(subjectService.findOneByName(subject3));
                subjects.add(subjectService.findOneByName(subject4));
            grouppP.setSubjects(subjects);
            grouppP.setFaculty(facultyService.findOneByName(facultyName));
            groupService.add(grouppP);
        }
        return "redirect:/";
    }
}
