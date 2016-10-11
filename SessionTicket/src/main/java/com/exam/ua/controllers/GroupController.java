package com.exam.ua.controllers;

import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.GroupP;
import com.exam.ua.services.FacultyService;
import com.exam.ua.services.GroupService;
import com.exam.ua.validators.GroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    private GroupValidator groupValidator;


    @RequestMapping(value = "/addGroup",method = RequestMethod.GET)
    public String newGroupPage(Model model,Model modelFaculties){
        List<Faculty> faculties = facultyService.findAll();
        modelFaculties.addAttribute("faculties",faculties);
        model.addAttribute("grouppP",new GroupP());
        return "views-group-new";
    }

    @RequestMapping(value = "/createGroup",method = RequestMethod.POST)
    public String createGroup(@ModelAttribute("grouppP") GroupP grouppP,
                                @RequestParam("facultySelect")String facultyName,
                                    Model modelFaculties,
                                        BindingResult bindingResult
                                            ){
        groupValidator.validate(grouppP,bindingResult);
        if (bindingResult.hasErrors()){
            modelFaculties.addAttribute("faculties",facultyService.findAll());
            return "views-group-new";
        }
        else {
          /*  List<Faculty> faculties = facultyService.findAll();
            for (Faculty faculty : faculties) {
                if (faculty.getName().equals(facultyName)) {
                    grouppP.setFaculty(faculty);
                    break;
                }
            }*/
            grouppP.setFaculty(facultyService.findOneByName(facultyName));
            groupService.add(grouppP);
        }
        return "redirect:/";
    }
}
