package com.exam.ua.controllers;

import com.exam.ua.entity.ExamForGroup;
import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.GroupP;
import com.exam.ua.entity.Subject;
import com.exam.ua.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Rostyslav on 01.11.2016.
 */
@Controller
public class AjaxController {
    @Autowired
    private ExamService examService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;

    private static final int WEAK_STRENGTH = 1;
    private static final int FEAR_STRENGTH = 5;
    private static final int STRONG_STRENGTH = 7;


    @RequestMapping(value = "/searchExamByCriterion",method = RequestMethod.GET)
    @ResponseBody
    public String allExamsByFaculty(@RequestParam String facultyName){
        Faculty faculty = null;
        List<ExamForGroup> examForGroupList = null;
        if (facultyName.equals("*")) {
            examForGroupList = examService.findAll();
        }
        else {
            faculty = facultyService.findOneByName(facultyName);
            examForGroupList = examService.findAllByFacultyId(faculty.getId());
        }
        String str = "";
        int count = 0;
        for (ExamForGroup exam: examForGroupList){
            if (count>0) str+="|";
            str+="Group: "+exam.getGroupP().getName()+"\n";
            str+="Subject: "+exam.getSubject().getName()+"\n";
            str+="Date: "+exam.getDate()+"\n";
            str+="Time: "+exam.getExamTime()+"\n";
            count++;
        }
        return str;
    }

    @RequestMapping(value = "/updateSearchSubject",method = RequestMethod.GET, produces = {"text/html; charset=UTF-8" })
    public @ResponseBody
    String updateGroupResult(@RequestParam String nameGroup){
        List<Subject> subjects = subjectService.findAll();

        String subjectsStr = "";
        for (int i = 0; i < subjects.size(); i++) {
            List<GroupP> groupPs = subjects.get(i).getGroupPs();
            for (GroupP group: groupPs){
                if (group.getName().equals(nameGroup)){
                    subjectsStr += subjects.get(i).getName() + "-";
                    break;
                }
            }
        }
        String result = "";
        for (int i = 0; i < subjectsStr.length()-1; i++)
            result+=subjectsStr.charAt(i);
        return result;
    }

    @RequestMapping(value = "/updateSearchGroup",method = RequestMethod.GET, produces = {"text/html; charset=UTF-8" })
    public @ResponseBody
    String updateGroupResult(@RequestParam String nameFaculty,Model model){
        List<GroupP> groupPs = null;
        if (nameFaculty.equals("*")) groupPs = groupService.findAll();
        else
            groupPs = groupService.findAllByNameFaculty(nameFaculty);
        String groups = "";
        for (int i = 0; i < groupPs.size()-1; i++){
            groups += groupPs.get(i).getName()+"-";
        }
        groups += groupPs.get(groupPs.size()-1).getName();
        return groups;
    }

    @RequestMapping(value = "/checkStrength",method = RequestMethod.GET, produces = {"text/html; charset=UTF-8" })
    public @ResponseBody
    String checkLength(@RequestParam String password){
        if (password.length()>=WEAK_STRENGTH && password.length()<FEAR_STRENGTH){
            return "Weak";
        } else if (password.length()>=FEAR_STRENGTH && password.length()<STRONG_STRENGTH){
            return "Fear";
        } else if (password.length()>=STRONG_STRENGTH) {
            return "Strong";
        }
        return "";
    }

    @RequestMapping(value = "/levelPassword",method = RequestMethod.GET)
    @ResponseBody
    public String levelPassword(@RequestParam String userPassword){
        if (userPassword.length()<6) return "weak red";
        else if (userPassword.length()>=6 && userPassword.length()<=10) return "average orange";
        else return "strong rgb(124,252,0)";
    }


    @RequestMapping(value = "/findExamsByGroup",method = RequestMethod.GET)
    @ResponseBody
    public String examsFound(@RequestParam String nameFaculty,@RequestParam String groupSelected){
       List<ExamForGroup> exams = null;
        if (nameFaculty.equals("*")){
            if (groupSelected.equals("*")) {
                exams = examService.findAll();
            } else {
                GroupP groupP = groupService.findOneByName(groupSelected);
                exams = examService.findAllByGroupId(groupP.getId());
            }
        } else {
            if (groupSelected.equals("*")) {
                Faculty faculty = facultyService.findOneByName(nameFaculty);
                exams = examService.findAllByFacultyId(faculty.getId());
            } else {
                GroupP groupP = groupService.findOneByName(groupSelected);
                exams = examService.findAllByGroupId(groupP.getId());
            }
        }
        String str = "";
        int count = 0;
        for (ExamForGroup exam: exams){
            if (count>0) str+="|";
            str+="Group: "+exam.getGroupP().getName()+"\n";
            str+="Subject: "+exam.getSubject().getName()+"\n";
            str+="Date: "+exam.getDate()+"\n";
            str+="Time: "+exam.getExamTime()+"\n";
            count++;
        }
        return str;
    }
}