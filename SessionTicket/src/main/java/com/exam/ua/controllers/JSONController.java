package com.exam.ua.controllers;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rostyslav on 03.11.2016.
 */
@Controller
public class JSONController extends BaseMethods{

    @RequestMapping(value = "/jsonPage",method = RequestMethod.GET,produces = {"text/html; charset=UTF-8" })
    public String goJsonPage(){
       /* JSONObject jsonObject = new JSONObject();
        jsonObject.putOnce("name","Rostyk");
        jsonObject.putOnce("age",19);
        jsonObject.putOnce("alive",true);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);*/

        /*model.addAttribute("studentt",jsonArray.toString());*/
        return "views-json-try";
    }


    @RequestMapping(value = "/jsonTry",method = RequestMethod.GET,produces = {"text/html; charset=UTF-8" })
    @ResponseBody
    public String tryJson(@RequestParam String name){

        JSONObject jsonObject = new JSONObject();
        jsonObject.putOnce("name","Rostyk");
        jsonObject.putOnce("age",19);
        jsonObject.putOnce("alive",true);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.putOnce("name","Rostyk1");
        jsonObject1.putOnce("age",191);
        jsonObject1.putOnce("alive",true);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject1);


        return  jsonArray.toString();
    }
}
