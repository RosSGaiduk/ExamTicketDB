package com.exam.ua.controllers;

import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.GroupP;
import com.exam.ua.entity.StudentOfLnu;
import com.exam.ua.services.FacultyService;
import com.exam.ua.services.GroupService;
import com.exam.ua.services.StudentService;
import com.exam.ua.validators.StudentValidator;
import javafx.scene.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostyslav on 10.10.2016.
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentValidator studentValidator;

    @RequestMapping(value = "/addStudent",method = RequestMethod.GET)
    public String addStudentPage(Model model,Model modelFaculty){
        StudentOfLnu studentOfLnu = new StudentOfLnu();
        model.addAttribute("student",studentOfLnu);
        modelFaculty.addAttribute("faculties",facultyService.findAll());
        return "views-student-new";
    }


    @RequestMapping(value = "/createStudent",method = RequestMethod.POST)
    public String createStudent(@ModelAttribute("student") StudentOfLnu student,
                                @RequestParam("facultySelect")String facultyName,
                                Model modelFaculty,
                                BindingResult bindingResult){

        studentValidator.validate(student,bindingResult);
      if (bindingResult.hasErrors()) {
          modelFaculty.addAttribute("faculties",facultyService.findAll());
          return "views-student-new";
      } else {
          student.setNameFaculty(facultyName);
          studentService.add(student);
          return "redirect:/newContinue";
      }
    }

    @RequestMapping(value = "/newContinue",method = RequestMethod.GET)
    public String createStudentContinue(Model model,Model modelGroups){
        StudentOfLnu studentOfLnu = studentService.findOne("select max(id) from StudentOfLnu");
        model.addAttribute("studentContinue",studentOfLnu);
        Faculty faculty = facultyService.findOneByName(studentOfLnu.getNameFaculty());
        Set<GroupP> groupPSet = new HashSet<>(); //не знаю чого але чомусь faculty.getGroups().size()==12???
        for (GroupP groupP:faculty.getGroups())
            groupPSet.add(groupP);
        modelGroups.addAttribute("groups",groupPSet);
        return "views-student-newContinue";
    }

    @RequestMapping(value = "/createStudentFinished",method = RequestMethod.POST)
    public String createStudentFinished(@ModelAttribute StudentOfLnu studentContinue,
                                        @RequestParam("groupSelect")String groupName
                                        ){
        StudentOfLnu studentOfLnu = studentService.findOne("select max(id) from StudentOfLnu");
        studentOfLnu.copyField(studentContinue);
        List<GroupP> groupPs = groupService.findAll();
        for (GroupP groupP: groupPs)
        if (groupP.getName().equals(groupName)){
            studentOfLnu.setGroupP(groupP);
            break;
        }
        studentService.edit(studentOfLnu);
        return "redirect:/";
    }

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }
}
