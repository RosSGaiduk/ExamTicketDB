package com.exam.ua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Controller
public class BaseController extends BaseMethods{
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "views-base-home";
    }
}
