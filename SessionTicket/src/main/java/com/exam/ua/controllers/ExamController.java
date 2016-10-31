package com.exam.ua.controllers;

import com.exam.ua.entity.ExamForGroup;
import com.exam.ua.entity.Faculty;
import com.exam.ua.services.ExamService;
import com.exam.ua.services.FacultyService;
import com.exam.ua.services.GroupService;
import com.exam.ua.services.SubjectService;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 11.10.2016.
 */
@Controller
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/addExam",method = RequestMethod.GET)
    public String newExamPage(Model model,Model model1){
        model1.addAttribute("faculties",facultyService.findAll());
        model.addAttribute("newExam",new ExamForGroup());
        return "views-exam-new";
    }

    @RequestMapping(value = "/createExam",method = RequestMethod.POST)
    public String createExam(@ModelAttribute ExamForGroup examForGroup,
                             @RequestParam("facultySelect") String faculty,
                             @RequestParam("groupSelect") String group,
                             @RequestParam("subjectSelect") String subjectName,
                             @RequestParam("dateCalendar")String dateCalendar){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(dateCalendar);
            examForGroup.setDate(date);
            examForGroup.setGroupP(groupService.findOneByName(group));
            examForGroup.setFaculty(facultyService.findOneByName(faculty));
            examForGroup.setSubject(subjectService.findOneByName(subjectName));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        examService.add(examForGroup);
        return "redirect:/";
    }

    //модель не передаватиму, бо зроблю через input та ajax
    @RequestMapping(value = "/allExams",method = RequestMethod.GET)
    public String allExams(Model model){
        model.addAttribute("faculties",facultyService.findAll());
        return "views-exam-all";
    }

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
            str+="Hour: "+exam.getHour()+"\n";
            str+="Minute: "+exam.getMinute()+"\n";
            count++;
        }
        return str;
    }
}
