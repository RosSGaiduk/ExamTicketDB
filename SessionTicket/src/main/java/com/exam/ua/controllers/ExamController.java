package com.exam.ua.controllers;

import com.exam.ua.entity.ExamForGroup;
import com.exam.ua.services.ExamService;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rostyslav on 11.10.2016.
 */
@Controller
public class ExamController {
    @Autowired
    private ExamService examService;

    @RequestMapping(value = "/addExam",method = RequestMethod.GET)
    public String newExamPage(Model model){
        model.addAttribute("newExam",new ExamForGroup());
        return "views-exam-new";
    }

    @RequestMapping(value = "/createExam",method = RequestMethod.POST)
    public String createExam(@ModelAttribute ExamForGroup examForGroup,
                             @RequestParam("dateCalendar")String dateCalendar){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(dateCalendar);
            examForGroup.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        examService.add(examForGroup);
        return "redirect:/";
    }
}
