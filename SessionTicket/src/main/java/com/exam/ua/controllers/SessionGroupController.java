package com.exam.ua.controllers;

import com.exam.ua.entity.ExamForGroup;
import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.GroupP;
import com.exam.ua.entity.SessionOfGroup;
import com.exam.ua.services.ExamService;
import com.exam.ua.services.FacultyService;
import com.exam.ua.services.GroupService;
import com.exam.ua.services.SessionGroupService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostyslav on 02.11.2016.
 */
@Controller
public class SessionGroupController {

    @Autowired
    private SessionGroupService sessionService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private ExamService examService;
    @Autowired
    private FacultyService facultyService;


    @RequestMapping(value = "/newSession",method = RequestMethod.GET)
    public String newSessionPage(Model model){
        model.addAttribute("faculties",facultyService.findAll());
        return "views-session-new";
    }

    @RequestMapping(value = "/createSession",method = RequestMethod.POST)
    public String createSession(@RequestParam String groupSelect,@RequestParam String countSelect){
        long count = Long.parseLong(countSelect);
        GroupP groupP = groupService.findOneByName(groupSelect);
        List<ExamForGroup> exams = new ArrayList<>();
        for (int i = 0; i < count; i++)
         exams.add(examService.findAllByGroupId(groupP.getId()).get(i));

        System.out.println(exams.size());

        SessionOfGroup sessionOfGroup = new SessionOfGroup();
        sessionService.add(sessionOfGroup);

        List<SessionOfGroup> sessionOfGroups = sessionService.findAll();
        //бо не можна зразу юзати sessionOfGroup, треба зробити новий запит, бо все в межах 1 транзакції

        for (ExamForGroup exam: exams){
            exam.setSessionOfGroup(sessionOfGroups.get(sessionOfGroups.size()-1));
            examService.edit(exam);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/allSessions",method = RequestMethod.GET)
    public String allSessionsPage(Model model){
        model.addAttribute("faculties",facultyService.findAll());
        return "views-session-all";
    }

    @RequestMapping(value = "/sessionsByFaculty",method = RequestMethod.GET)
    @ResponseBody
    public String sessionsByFaculty(@RequestParam String facultyName){
        Faculty faculty = facultyService.findOneByName(facultyName);


        /*JSONObject jsonObject1 = new JSONObject();
        jsonObject1.putOnce("name","Rostyk1");
        jsonObject1.putOnce("age",191);
        jsonObject1.putOnce("alive",true);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject1);*/


        List<SessionOfGroup> sessionOfGroups = sessionService.findAllByFacultyId(faculty.getId());
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < sessionOfGroups.size(); i++){
            Set<ExamForGroup> exams = sessionOfGroups.get(i).getExams();
            for (ExamForGroup examForGroup: exams) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.putOnce("count",exams.size());
                jsonObject.putOnce("groupp",examForGroup.getGroupP().getName());
                jsonObject.putOnce("subject",examForGroup.getSubject().getName());
                jsonObject.putOnce("date",examForGroup.getDate());
                jsonObject.putOnce("time",examForGroup.getExamTime());
                jsonArray.put(jsonObject);
            }
        }
        return jsonArray.toString();
    }
}
