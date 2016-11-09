package com.exam.ua.controllers;

import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.Subject;
import com.exam.ua.entity.Teacher;
import com.exam.ua.services.FacultyService;
import com.exam.ua.services.SubjectService;
import com.exam.ua.services.TeacherService;
import com.exam.ua.validators.TeacherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Rostyslav on 10.10.2016.
 */
@Controller
public class TeacherController extends BaseMethods{
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TeacherValidator teacherValidator;

    @RequestMapping(value = "/addTeacher",method = RequestMethod.GET)
    public String newTeacherPage(Model model,Model modelFaculty,Model modelSubject){
        Teacher teacher = new Teacher();
        model.addAttribute("newTeacher",teacher);
        modelFaculty.addAttribute("faculties",facultyService.findAll());
        modelSubject.addAttribute("subjects",subjectService.findAll());
        return "views-teacher-new";
    }

    @RequestMapping(value = "/createTeacher",method = RequestMethod.POST)
    public String createTeacher(@ModelAttribute("newTeacher") Teacher newTeacher,
                                @RequestParam("birthDate")String date,
                                @RequestParam("facultySelect")String nameFaculty,
                                @RequestParam("subjectSelect")String nameSubject,
                                Model modelFaculty,Model modelSubject,
                                BindingResult bindingResult
                                ){
       DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birth = formatter.parse(date);
            newTeacher.setBirth(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newTeacher.setName(stringUTF_8Encode(newTeacher.getName()));
        newTeacher.setLastName(stringUTF_8Encode(newTeacher.getLastName()));
        newTeacher.setSeat(stringUTF_8Encode(newTeacher.getSeat()));
        nameFaculty = stringUTF_8Encode(nameFaculty);
        nameSubject = stringUTF_8Encode(nameSubject);

        teacherValidator.validate(newTeacher,bindingResult);

        if (bindingResult.hasErrors()){
            modelFaculty.addAttribute("faculties",facultyService.findAll());
            modelSubject.addAttribute("subjects",subjectService.findAll());
            return "views-teacher-new";
        } else {
            newTeacher.getFaculties().add(facultyService.findOneByName(nameFaculty));
            newTeacher.getSubjects().add(subjectService.findOneByName(nameSubject));
            teacherService.add(newTeacher);
            return "redirect:/";
        }
    }
    @RequestMapping(value = "/allTeachers",method = RequestMethod.GET)
    public String allTeachersPage(Model model,Model facultiesModel){
        List<Teacher> teacherList = teacherService.findAll();
        model.addAttribute("teachers",teacherList);
        facultiesModel.addAttribute("faculties",facultyService.findAll());
        return "views-teacher-all";
    }

    @RequestMapping(value = "/teacherSelect/{id}",method = RequestMethod.GET)
    public String teacherSelected(@PathVariable String id,Model model,Model facultyModel,Model subjectModel){
        model.addAttribute("teacher",teacherService.findOne(Long.parseLong(id)));
        List<Faculty> faculties = facultyService.findAll();
        Set<Faculty> facultiesTeacherHave = teacherService.findOne(Long.parseLong(id)).getFaculties();
        Set<Faculty> facultiesNotHaveTeacher = new TreeSet<>();

        for (int i = 0; i < faculties.size(); i++){
            int count = 0;
            for (Faculty faculty: facultiesTeacherHave){
                if (faculties.get(i).getName().equals(faculty.getName())){
                    break;
                } else {
                    count++;
                }
            }
            if (count == facultiesTeacherHave.size()) facultiesNotHaveTeacher.add(faculties.get(i));
        }


        List<Subject> subjects = subjectService.findAll();
        Set<Subject> subjectsTeacherHave = teacherService.findOne(Long.parseLong(id)).getSubjects();
        Set<Subject> subjectsNotHaveTeacher = new TreeSet<>();

        for (int i = 0; i < subjects.size(); i++){
            int count = 0;
            for (Subject subject: subjectsTeacherHave){
                if (subjects.get(i).getName().equals(subject.getName())){
                    break;
                } else {
                    count++;
                }
            }
            if (count == subjectsTeacherHave.size()) subjectsNotHaveTeacher.add(subjects.get(i));
        }

        facultyModel.addAttribute("faculties",facultiesNotHaveTeacher);
        subjectModel.addAttribute("subjects",subjectsNotHaveTeacher);
        return "views-teacher-selected";
    }

    @RequestMapping(value = "/editTeacher",method = RequestMethod.POST)
    public String editTeacher(@RequestParam String idTeacher,
                              @RequestParam String addFacultyToTeacher,
                              @RequestParam String addSubjectToTeacher){

        System.out.println("asd");
       /* Teacher teacher = teacherService.findOne(Long.parseLong(idTeacher));*/
        //System.out.println(teacher.getName());

       /* addFacultyToTeacher = stringUTF_8Encode(addFacultyToTeacher);
        addSubjectToTeacher = stringUTF_8Encode(addSubjectToTeacher);

        if (!addFacultyToTeacher.equals("no faculty")) {
            Faculty faculty = facultyService.findOneByName(addFacultyToTeacher);
            teacherService.addFaculty(teacher, faculty);
        }

        if (!addSubjectToTeacher.equals("no subject")){
            Subject subject = subjectService.findOneByName(addSubjectToTeacher);
            teacherService.addSubject(teacher,subject);
        }*/

        return "redirect:/";
    }
}
