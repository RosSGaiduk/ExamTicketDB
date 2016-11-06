package com.exam.ua.controllers;

import com.exam.ua.entity.Faculty;
import com.exam.ua.entity.GroupP;
import com.exam.ua.entity.Subject;
import com.exam.ua.services.FacultyService;
import com.exam.ua.services.SubjectService;
import com.exam.ua.validators.SubjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Rostyslav on 11.10.2016.
 */
@Controller
public class SubjectController extends BaseMethods{
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectValidator subjectValidator;
    @Autowired
    private FacultyService facultyService;

    @RequestMapping(value = "/allSubjects",method = RequestMethod.GET)
    public String subjectsAllPage(Model model){
        model.addAttribute("subjects",subjectService.findAll());
        return "views-subject-all";
    }

    @RequestMapping(value = "/addSubject",method = RequestMethod.GET)
    public String newSubjectPage(Model model,Model model1){
        model1.addAttribute("faculties",facultyService.findAll());
        model.addAttribute("subject",new Subject());
        return "views-subject-new";
    }

    @RequestMapping(value = "/createSubject",method = RequestMethod.POST)
    public String createSubject(@ModelAttribute("subject") Subject subject,
                                @RequestParam("facultySelect") String facultyName,
                                Model model1,
                                BindingResult bindingResult){
        try {
            subject.setName(new String(subject.getName().getBytes("ISO-8859-1"),"UTF8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        subjectValidator.validate(subject,bindingResult);
        if (bindingResult.hasErrors()){
            model1.addAttribute("faculties",facultyService.findAll());
            return "views-subject-new";
        }
        facultyName = stringUTF_8Encode(facultyName);
        subject.getFaculties().add(facultyService.findOneByName(facultyName));
        subjectService.add(subject);
        return "redirect:/allSubjects";
    }

    //цей метод для того, щоб добавляти предмету факультети, оскільки в нас зв'язок manyToMany, 1 предмет може бути
    //на багатьох факультетах, тому потрібно дати можливість кожному предмету добавити факультет, для цього буде form
    //на сторінці html, яка в select пропонуватиме список всіх факультетів, що предмет за даним {id} не містить, і якщо ми
    //виберемо 1 з факультетів з даного списку, тоді в дерево факультетів (TreeSet) цього предмету добавиться ще 1
    //факультет, той , який ми вибрали.
    @RequestMapping(value = "/subject/{id}",method = RequestMethod.GET)
    public String subjectSelect(@PathVariable String id,Model model,Model facultyModel){
        Subject subject = subjectService.findOne(Long.parseLong(id));
        List<Faculty> faculties = facultyService.findAll();
        Set<Faculty> facultiesOfSubject = subject.getFaculties();
        Set<Faculty> facultiesThatSubjectNotHave = new TreeSet<>();

        //Алгоритм пошуку  тих факультетів, які не містять даного предмету
        for (int i = 0; i < faculties.size(); i++){
            int count = 0;
            for (Faculty faculty: facultiesOfSubject){
                if (faculties.get(i).getName().equals(faculty.getName())){
                    break;
                } else {
                    count++;
                }
            }
            if (count == facultiesOfSubject.size()) facultiesThatSubjectNotHave.add(faculties.get(i));
        }


        facultyModel.addAttribute("faculties",facultiesThatSubjectNotHave);
        model.addAttribute("subjectSelected",subject);
        return "views-subject-selected";
    }

    @RequestMapping(value = "/editSubject",method = RequestMethod.POST)
    public String editSubject(@RequestParam String idSubject,@RequestParam String facultySelect) {
        facultySelect = stringUTF_8Encode(facultySelect);
        Subject subject = subjectService.findOne(Long.parseLong(idSubject));
        System.out.println(subject.getName());
        Faculty faculty = facultyService.findOneByName(facultySelect);
        System.out.println(faculty.getId());

        //Не працює чомусь
        //subject.getFaculties().add(faculty);
        //subjectService.edit(subject);

        //Провірка, чи є вже даний факультет у цього предмета, якщо є, тоді return "redirect:/", якщо ні, тоді додати
        //чомусь, не зважаючи на те, що в нас Subject містить TreeSet факультетів, воно всеодно додасть факультет, якщо
        //навіть він вже присутній якщо зробимо subject.getFaculties().add(faculty);  і потім на сайті викине error
        //Тому я створив new TreeSet, якому присвоїв всі факультети даного предмету і спробував додати в нього ще 1.
        //Тоді, якщо в цьому новому TreeSet вже існуватиме факультет, який ми пробуєм додати, він не додасть(зробить правильно).
        //Тому я зробив так:
        Set<Faculty> faculties = new TreeSet<>();
        for (Faculty faculty1 : subject.getFaculties()) faculties.add(faculty1);
        int countBefore = faculties.size();
        faculties.add(faculty);
        int countAfrer = faculties.size();
        //хоча цього вже і не треба робити, бо я доробив так, щоб в select не було ні 1 опції, яка пропонуватиме факультет,
        //який вже містить даний предмет, але щоб не забути як добавляти через сайт сутності зі зв'язками ManyToMany, нехай буде
        if (countBefore == countAfrer) return "redirect:/";
        else {
            subjectService.addFacultyToSubject(subject, faculty);
            return "redirect:/";
        }

    }
}
