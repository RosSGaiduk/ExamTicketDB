package com.exam.ua.controllers;

import com.exam.ua.entity.User;
import com.exam.ua.services.UserService;
import com.exam.ua.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rostyslav on 21.10.2016.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;



    private static final int WEAK_STRENGTH = 1;
    private static final int FEAR_STRENGTH = 5;
    private static final int STRONG_STRENGTH = 7;


    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUserPage(Model model){
        model.addAttribute("newUser",new User());
        return "views-user-new";
    }

    @RequestMapping(value = "/createUser",method = RequestMethod.POST)
    public String createUser(@ModelAttribute("newUser")User newUser,
                             @RequestParam("birthDateUser")String dateCalendar,
                             BindingResult bindingResult
                             ){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(dateCalendar);
            newUser.setBirthDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        userValidator.validate(newUser,bindingResult);
        if (bindingResult.hasErrors()){
            return "views-user-new";
        }

        userService.add(newUser);
        return "redirect:/";
    }

    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    public String goLogin(Model model){
        model.addAttribute("user",new User());
        return "views-user-login";
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
}
