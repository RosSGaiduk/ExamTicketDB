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
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Rostyslav on 10.10.2016.
 */
@Controller
public class StudentController extends BaseMethods{
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
                                @RequestParam("birth") String date,
                                @RequestParam("facultySelect")String facultyName,
                                @RequestParam("groupSelect")String groupName,
                                Model modelFaculty,
                                BindingResult bindingResult){

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birth = formatter.parse(date);
            student.setBirthDate(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setName(stringUTF_8Encode(student.getName()));
        student.setLastName(stringUTF_8Encode(student.getLastName()));
        student.setForm(stringUTF_8Encode(student.getForm()));
        facultyName = stringUTF_8Encode(facultyName);
        groupName = stringUTF_8Encode(groupName);

        studentValidator.validate(student,bindingResult);
      if (bindingResult.hasErrors()) {
          modelFaculty.addAttribute("faculties",facultyService.findAll());
          return "views-student-new";
      } else {
          student.setNameFaculty(facultyName);
          student.setGroupP(groupService.findOneByName(groupName));
          studentService.add(student);
          return "redirect:/";
      }
    }


    @RequestMapping(value = "/tryingStudent",method = RequestMethod.GET)
    public String goTry(Model model,Model model1)
    {
        model.addAttribute("faculties",facultyService.findAll());
        /*model1.addAttribute("groups",groupService.findAll());*/
        return "views-base-groupFacultyTrying";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /* @RequestMapping(value = "/updateSearchGroup",method = RequestMethod.GET, produces = {"text/html; charset=UTF-8" })
    public @ResponseBody
    String updateGroupResult(@RequestParam String nameFaculty,Model model){
        model.addAttribute("groups",groupService.findAllByNameFaculty(nameFaculty));


        //model.addAttribute("groups",groupService.findAll());
        //return "views-base-groupFacultyTrying";
        //return "redirect:/tryingStudent";


        return nameFaculty;
    }*/


    /*@RequestMapping(value = "/updateSearchGroup",method = RequestMethod.GET, produces = {"text/html; charset=UTF-8" })
    public @ResponseBody
    List<GroupP> updateGroupResult(@RequestParam String nameFaculty,Model model){
        //model.addAttribute("groups",groupService.findAllByNameFaculty(nameFaculty));
        //model.addAttribute("groups",groupService.findAll());
        //return "views-base-groupFacultyTrying";
        //return "redirect:/tryingStudent";
        return groupService.findAll();
    }*/


    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }
}
