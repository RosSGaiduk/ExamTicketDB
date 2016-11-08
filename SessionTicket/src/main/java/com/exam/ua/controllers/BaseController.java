package com.exam.ua.controllers;

import com.exam.ua.services.UniversityService;
import com.exam.ua.services.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Controller
public class BaseController extends BaseMethods{
    @Autowired
    private WriterService writerService;
    @Autowired
    private UniversityService universityService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model,Model model1){
        model.addAttribute("writerCount",writerService.findAll().size());
        model1.addAttribute("lnu",universityService.findOne(1l));
        return "views-base-home";
    }
}
