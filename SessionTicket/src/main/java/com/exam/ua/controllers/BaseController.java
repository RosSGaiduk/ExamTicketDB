package com.exam.ua.controllers;

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
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("writerCount",writerService.findAll().size());
        return "views-base-home";
    }
}
