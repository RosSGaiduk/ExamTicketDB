package com.exam.ua.controllers;

import com.exam.ua.entity.ExamForGroup;
import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.Teacher;
import com.exam.ua.services.*;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/addExam",method = RequestMethod.GET)
    public String newExamPage(Model model,Model model1){
        model.addAttribute("newExam",new ExamForGroup());
        model1.addAttribute("faculties",facultyService.findAll());
        return "views-exam-new";
    }

    @RequestMapping(value = "/createExam",method = RequestMethod.POST)
    public String createExam(@ModelAttribute ExamForGroup examForGroup,
                             @RequestParam("facultySelect") String faculty,
                             @RequestParam("groupSelect") String group,
                             @RequestParam("subjectSelect") String subjectName,
                             @RequestParam("teachers") String teacher,
                             @RequestParam("dateCalendar")String dateCalendar,
                             @RequestParam("timeForExam")String timeForExam){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(dateCalendar);
            examForGroup.setDate(date);
            String[]teachersIdentifications = teacher.split(" ");
            List<Teacher> teachers = teacherService.findAll();
            Teacher teacher1 = new Teacher(teachersIdentifications[0],teachersIdentifications[1],Integer.parseInt(teachersIdentifications[2]),teachersIdentifications[3]);
            for (int i = 0; i < teachers.size(); i++){
                if (teachers.get(i).compareTo(teacher1) == 0){
                    examForGroup.setTeacher(teachers.get(i));
                    break;
                }
            }
            examForGroup.setGroupP(groupService.findOneByName(group));
            examForGroup.setFaculty(facultyService.findOneByName(faculty));
            examForGroup.setSubject(subjectService.findOneByName(subjectName));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        long ms = 0;
        try {
            ms = sdf.parse(timeForExam).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Time time = new Time(ms);
        examForGroup.setExamTime(time);
        examService.add(examForGroup);
        return "redirect:/";
    }

    //модель не передаватиму, бо зроблю через input та ajax
    @RequestMapping(value = "/allExams",method = RequestMethod.GET)
    public String allExams(Model model){
        model.addAttribute("faculties",facultyService.findAll());
        return "views-exam-all";
    }
}
