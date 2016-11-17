package com.exam.ua.controllers;

import com.exam.ua.entity.*;
import com.exam.ua.entity.User;
import com.exam.ua.services.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.*;

/**
 * Created by Rostyslav on 01.11.2016.
 */
@Controller
public class AjaxController extends BaseMethods{
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
    private TeacherService teacherService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private WriterService writerService;
    @Autowired
    private UniversityService universityService;
    @Autowired
    private MessageService messageService;

    private static final int WEAK_STRENGTH = 1;
    private static final int FEAR_STRENGTH = 5;
    private static final int STRONG_STRENGTH = 7;


    @RequestMapping(value = "/searchExamByCriterion",method = RequestMethod.GET,produces = {"text/html; charset=UTF-8" })
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
            str+="Id:"+exam.getId()+"\n"; //обов'язково без пробіла після Id:, тому, що буде помилка в PathVariable-методі
            // в ExamCntroller
            str+="Group: "+exam.getGroupP().getName()+"\n";
            str+="Subject: "+exam.getSubject().getName()+"\n";
            if (exam.getTeacher()!=null)
                str+="Teacher: "+exam.getTeacher().getLastName()+" "+exam.getTeacher().getName()+"\n";
            else str+="Teacher: "+"\n";
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
            Set<GroupP> groupPs = subjects.get(i).getGroupPs();
            for (GroupP group: groupPs){
                if (group.getName().equals(nameGroup)){
                    Set<ExamForGroup> exams = group.getExamForGroupSet();
                    boolean groupAlreadyHasThisSubject = false;
                        for (ExamForGroup exam:exams){
                            if (exam.getSubject().getName().equals(subjects.get(i).getName())){
                                groupAlreadyHasThisSubject = true;
                                break;
                            }
                        }
                    if (!groupAlreadyHasThisSubject) {
                        subjectsStr += subjects.get(i).getName() + "-";
                        break;
                    }
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

    @RequestMapping(value = "/levelPassword",method = RequestMethod.GET,produces = {"text/html; charset=UTF-8" })
    @ResponseBody
    public String levelPassword(@RequestParam String userPassword){
        if (userPassword.length()<6) return "weak red";
        else if (userPassword.length()>=6 && userPassword.length()<=10) return "average orange";
        else return "strong rgb(124,252,0)";
    }

    @RequestMapping(value = "/findExamsByGroup",method = RequestMethod.GET,produces = {"text/html; charset=UTF-8" })
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
            str+="Id:"+exam.getId()+"\n"; //обов'язково без пробіла після Id:, тому, що буде помилка в PathVariable-методі
            // в ExamCntroller
            str+="Group: "+exam.getGroupP().getName()+"\n";
            str+="Subject: "+exam.getSubject().getName()+"\n";
            if (exam.getTeacher()!=null)
                str+="Teacher: "+exam.getTeacher().getLastName()+" "+exam.getTeacher().getName()+"\n";
            else str+="Teacher: "+"\n";
            str+="Date: "+exam.getDate()+"\n";
            str+="Time: "+exam.getExamTime()+"\n";
            count++;
        }
        return str;
    }

    @RequestMapping(value = "/findTeachersBySubject",method = RequestMethod.GET,produces = {"text/html; charset=UTF-8" })
    @ResponseBody
    public String findTeachers(@RequestParam String nameFaculty,@RequestParam String nameSubject){
        Subject subject = subjectService.findOneByName(nameSubject);
        Set<Teacher> teachers = subject.getTeachers();
        System.out.println(teachers.size());
        Set<Teacher> teachersOfFaculty = new TreeSet<>();
        for (Teacher teacher: teachers){
            Set<Faculty> facultiesOfTeacher = teacher.getFaculties();
            for (Faculty faculty:facultiesOfTeacher) {
                if (faculty.getName().equals(nameFaculty)) {
                    teachersOfFaculty.add(teacher);
                    break;
                }
            }
        }

        JSONArray jsonArray = new JSONArray();

        List<Teacher> teachers1 = new ArrayList<>(teachersOfFaculty);
        for (int i = 0; i < teachers1.size(); i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.putOnce("name",teachers1.get(i).getName());
            jsonObject.putOnce("lastName",teachers1.get(i).getLastName());
            jsonObject.putOnce("seat",teachers1.get(i).getSeat());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }


    @RequestMapping(value = "/findTeachersByFaculty",method = RequestMethod.GET,produces = {"text/html; charset=UTF-8" })
    @ResponseBody
    public String findTeachersByFaculty(@RequestParam String nameFaculty){
        List<Teacher> teachers = teacherService.findAll();
        Set<Teacher> teachersOfFaculty = new TreeSet<>();
        for (Teacher teacher: teachers){
            Set<Faculty> facultiesOfTeacher = teacher.getFaculties();
            for (Faculty faculty: facultiesOfTeacher){
                if (faculty.getName().equals(nameFaculty)){
                    teachersOfFaculty.add(teacher);
                    break;
                }
            }
        }


        JSONArray jsonArray = new JSONArray();
        for (Teacher teacher: teachersOfFaculty){
            Set<Subject> subjects = teacher.getSubjects();
            JSONObject jsonObject = new JSONObject();
            jsonObject.putOnce("lastName",teacher.getLastName());
            jsonObject.putOnce("name",teacher.getName());
            String str = teacher.getBirth().toString();
            String yearMonthDay = "";
            //забрати години, хвилини, секунди,мілісекунди
            for (int i = 0; i < str.length()-10; i++)
                yearMonthDay+=str.charAt(i);

            jsonObject.putOnce("id",teacher.getId());
            jsonObject.putOnce("birth",yearMonthDay);
            jsonObject.putOnce("seat",teacher.getSeat());
            String subjectsStr = "";
            for (Subject subject: subjects)
                subjectsStr+=subject.getName()+" ";
            jsonObject.putOnce("subjects",subjectsStr);
            jsonArray.put(jsonObject);
        }


        return jsonArray.toString();
    }

    @RequestMapping(value = "/changeWriter",method = RequestMethod.GET,produces = {"text/html; charset=UTF-8" })
    @ResponseBody
    public String changeWriter(@RequestParam String id){
        Writer writer = writerService.findOne(Long.parseLong(id));
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOnce("biography",writer.getBiography());
        jsonObject.putOnce("urlImage",writer.getUrlImage());
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        return jsonArray.toString();
    }

    @RequestMapping(value = "/changeUniversityImage",method = RequestMethod.GET,produces = {"text/html; charset=UTF-8"})
    @ResponseBody
    public String changeUniversityImage(@RequestParam String id){
        University university = universityService.findOne(1l);
        int idLong = Integer.parseInt(id);
        String url = "";
        switch (idLong){
            case 1:{
                url = university.getUrlImage();
            } break;
            case 2:{
                url = university.getUrlImage1();
            } break;
            case 3:{
                url = university.getUrlImage2();
            } break;
            case 4:{
                url = university.getUrlImage3();
            } break;
        }
        return url;
    }



    @RequestMapping(value = "/messageFromUser",method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    @ResponseBody
    public String addMessageFromUser(@RequestParam String message,@RequestParam String idUser){
        System.out.println("Message: "+message);
        System.out.println(idUser);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        /*System.out.println("Principal: "+authentication.getPrincipal());
        System.out.println("Name: "+authentication.getName());
        System.out.println("Name int: "+Integer.parseInt(authentication.getName()));
        System.out.println("Credentials: "+authentication.getCredentials());
        System.out.println("Details: "+authentication.getDetails());*/
        /*String textFromAdmin = "hello from admin";*/

        //якщо повідомлення не від адміна а від звичайного користувача

        if (Integer.parseInt(authentication.getName())!=1) {
            Message message1 = new Message();
            message1.setUserFrom(userService.findOne(Integer.parseInt(authentication.getName())));
            message1.setUserTo(userService.findOne(1l));
            message1.setText(message);
            Date date = new Date(System.currentTimeMillis());
            message1.setDateOfMessage(date);
            messageService.add(message1);
        }
        else {
            Message message1 = new Message();
            message1.setUserFrom(userService.findOne(Integer.parseInt(authentication.getName())));
            message1.setUserTo(userService.findOne(Long.parseLong(idUser)));
            message1.setText(message);
            Date date = new Date(System.currentTimeMillis());
            message1.setDateOfMessage(date);
            messageService.add(message1);
        }
        return message;
    }

    //всі повідомлення, які писались адміну від всіх користувачів


    @RequestMapping(value = "/randomMessageFromRandomUser",method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    @ResponseBody
    public String randomMessageFromRandomUser(){
        Random rand = new Random();
        Integer text = rand.nextInt(100);
        Message message = new Message();
        Date date = new Date(System.currentTimeMillis());
        message.setDateOfMessage(date);

        int randUser = rand.nextInt(2)+2;

        User user = userService.findOne(randUser);
        message.setUserFrom(user);
        message.setUserTo(userService.findOne(1l));
        message.setText(text.toString());
        messageService.add(message);
        return user.getId()+"~"+text.toString();
    }

    @RequestMapping(value = "/userChanged",method = RequestMethod.GET, produces = {"text/html;  charset=UTF-8"})
    @ResponseBody
    public String messagesBetweenUserCheckedFromSelectAndAdmin(@RequestParam String idOfUser){
        System.out.println("here");
        List<Message> messages = messageService.findAll();
        JSONArray jsonArray = new JSONArray();


        long idCheckedUser = Long.parseLong(idOfUser);
        //Якщо адмін вибрав діалог з іншим юзером, тоді відобразити у відповідному блоці div всю історію переписки між
        //адміном та даним юзером, якого адмін обрав.
        for (Message m: messages){
            if (m.getUser().getId()==idCheckedUser || m.getUserTo().getId()==idCheckedUser){
                JSONObject jsonObject = new JSONObject();
                jsonObject.putOnce("text",m.getText());
                jsonObject.putOnce("data",m.getDateOfMessage());
                if (m.getUser().getId()==idCheckedUser) jsonObject.putOnce("fromUser",true);
                else jsonObject.putOnce("toUser",false);
                jsonArray.put(jsonObject);
            }
        }


        return jsonArray.toString();
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    @ResponseBody
    public String messagesUpdate(@RequestParam String idUser,@RequestParam String size){
        //System.out.println("ID user: "+idUser);
        //System.out.println("Size: "+size);

        long idUserLong = Long.parseLong(idUser);
        int sizeInt = Integer.parseInt(size);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long authName = Long.parseLong(authentication.getName());

        System.out.println(authName);

        List<Message> messages = messageService.findAll();

        int count = 0;
        if (authName==1) {
            for (Message m : messages)
                if (m.getUser().getId() == idUserLong || m.getUserTo().getId() == idUserLong)
                    count++;
        }
         else {
            count = 0;
            for (Message m1 : messages)
                if (m1.getUser().getId() == authName || m1.getUserTo().getId() == authName)
                    count++;
        }

        //System.out.println("Count: "+count);
        //System.out.println("Size: "+count);

        if (count>sizeInt) return "true";
        else return "false";
    }
}
