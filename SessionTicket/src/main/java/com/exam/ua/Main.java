package com.exam.ua;

import com.exam.ua.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.datetime.DateFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public class Main {


    private static Date stringToDate(String str){
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void deleteFaculty(long id){
        List<GroupP> groupPs = entityManager.find(Faculty.class,id).getGroups();
        for (GroupP groupP: groupPs){
            Set<StudentOfLnu> studentOfLnus = groupP.getStudents();
            for (StudentOfLnu studentOfLnu: studentOfLnus){
                entityManager.remove(entityManager.find(StudentOfLnu.class,studentOfLnu.getId()));
            }
            entityManager.remove(groupP);
        }

        entityManager.remove(entityManager.find(Faculty.class,id));
    }

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("Main");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

       /* String [] faculties = {"Biologic","Geographic","Geologic","Economical","Electronics","Foreign languages",
            "Historical","Art and Culture", "Mechanics and mathematics","International relations",
            "Teacher's education","Applied mathematics and informatics","Management of finances and business",
                "Physical","Philological","Philosophical","Chemical","Juridical"
        };

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        boolean filled = false;
        while(!filled){
            System.out.print("Enter date of exam: ");
            String dateStr = scanner.nextLine();
            Date date = stringToDate(dateStr);
            System.out.print("Enter hour: ");
            int hour = scanner1.nextInt();
            System.out.print("Enter minute: ");
            int minute = scanner1.nextInt();
            System.out.print("Enter faculty: ");
            String faculty = scanner.nextLine();
            Object obj = entityManager.createQuery("from Faculty where name like ?1").setParameter(1,faculty).getSingleResult();
            Faculty faculty1 = (Faculty) obj;
            List<GroupP> groupPs = entityManager.createQuery("from GroupP").getResultList();
            List<GroupP> groupPsFromFaculty = new ArrayList<>();
            for (int i = 0; i < groupPs.size(); i++){
                if (groupPs.get(i).getFaculty().equals(faculty1)){
                    groupPsFromFaculty.add(groupPs.get(i));
                }
            }

            System.out.println("Enter:");
            for (int i = 0; i < groupPsFromFaculty.size(); i++){
                System.out.println((i+1)+"-"+groupPsFromFaculty.get(i).getName());
            }
            int choiceGroup = scanner1.nextInt();
            List<Subject>subjects = entityManager.createQuery("from Subject").getResultList();
            List<Subject>subjectsOfGroup = new ArrayList<>();

            System.out.println("Enter subject: ");
            for (int i = 0; i < subjects.size(); i++){
                List<GroupP> groupPsSubject = subjects.get(i).getGroupPs();
                for (int j = 0; j < groupPsSubject.size(); j++){
                    if (groupPsSubject.get(j).getName().equals(groupPsFromFaculty.get(choiceGroup-1).getName())){
                        subjectsOfGroup.add(subjects.get(i));
                        System.out.println(
                                subjectsOfGroup.size()+"-"+
                                subjectsOfGroup.get(subjectsOfGroup.size()-1).getName());
                        break;
                    }
                }
            }
            int choiceSubject = scanner1.nextInt();
            ExamForGroup examForGroup = new ExamForGroup();
            examForGroup.setDate(date); examForGroup.setHour(hour); examForGroup.setMinute(minute);
            examForGroup.setFaculty(faculty1); examForGroup.setGroupP(groupPsFromFaculty.get(choiceGroup-1));
            examForGroup.setSubject(subjectsOfGroup.get(choiceSubject-1));
            System.out.println("Enter: c/continue, e/exit");
            entityManager.persist(examForGroup);
            char c = scanner.next().charAt(0);
            if (c == 'e') filled = true;
        }*/


      /*  String s = "23:59";
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        long ms = 0;
        try {
            ms = sdf.parse(s).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Time time = new Time(ms);
        System.out.println(time);*/


       /* SessionOfGroup session = entityManager.find(SessionOfGroup.class,19l);
        ExamForGroup examForGroup = entityManager.find(ExamForGroup.class,53l);
        examForGroup.setSessionOfGroup(session);
        entityManager.merge(examForGroup);
        entityManager.merge(session);*/
        /*System.out.println(entityManager.find(SessionOfGroup.class,18l).getExams().size());*/

        /*System.out.println(entityManager.find(SessionOfGroup.class,44l).getExams().size());
        System.out.println(entityManager.find(ExamForGroup.class,52l).getSessionOfGroup().getId());*/


/*
        Subject subject = entityManager.find(Subject.class,2l);
        System.out.println(subject.getTeachers().size());

        Teacher teacher = entityManager.find(Teacher.class,25l);
        System.out.println(teacher.getSubjects().size());*/
        /*Faculty faculty = entityManager.find(Faculty.class,3l);*/
        /*System.out.println(faculty.getName());*/
      /*  SessionOfGroup sessionOfGroup = entityManager.find(SessionOfGroup.class,5l);
        Set<ExamForGroup> exams = sessionOfGroup.getExams();
        for (ExamForGroup exam:exams){
            System.out.println(exam.getDate()+" "+exam.getExamTime()+" "+exam.getSubject().getName());
        }*/

       /* Subject subject = entityManager.find(Subject.class,2l);
        *//*subject.getFaculties().add(entityManager.find(Faculty.class,2l));
        entityManager.merge(subject);*//*
        System.out.println(subject.getFaculties().size());*/


        //Працює
        // List<Message> messages = entityManager.createQuery("from Message where (user_id = ?1 and userTo_id = ?2) or (userTo_id = ?1 and user_id = ?2) order by id").setParameter(1,1l).setParameter(2,2l).getResultList();


        /*List<Message> messages = entityManager.createQuery("from Message where (user_id = ?1 and userTo_id = ?2) or (userTo_id = ?1 and user_id = ?2) order by id desc").setParameter(1,1l).setParameter(2,2l).setMaxResults(3).getResultList();
        for (Message m: messages)
            System.out.println(m.getText());*/


        Object count = entityManager.createQuery("select count(id) from Message where (user_id = ?1 and userTo_id = ?2) or (userTo_id = ?1 and user_id = ?2) order by id desc").setParameter(1,3).setParameter(2,3).getSingleResult();
        long l = (long) count;
        System.out.println(l);


        /*Set<Faculty> faculties = new TreeSet<>();
        faculties.add(entityManager.find(Faculty.class,1l));
        faculties.add(entityManager.find(Faculty.class,2l));
        faculties.add(entityManager.find(Faculty.class,2l));
        System.out.println(faculties.size());*/

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}









       /* for (String str:faculties){
            Faculty faculty = new Faculty(str);
            entityManager.persist(faculty);
        }*/

       /* String str = "select max(id) from StudentOfLnu";
        Object o = entityManager.createQuery(str).getSingleResult();
        long i = Integer.parseInt(o.toString());
        System.out.println(i);*/

       /* String name = "Applied mathematics and informatics";
        Object o = entityManager.createQuery("select id from Faculty where name like ?1").setParameter(1,name).getSingleResult();
        long id = Integer.parseInt(o.toString());
        System.out.println(id);*/


       /* Object o =
                entityManager.createQuery("select id from Faculty where name like ?1").setParameter(1,"Applied mathematics and informatics").getSingleResult();
        long id = Integer.parseInt(o.toString());*/

       /* List<GroupP> groupPs = entityManager.find(Faculty.class,id).getGroups();*/
        /*HashSet<GroupP> groupPs1 = new HashSet<>();
        groupPs1.a*/
        /*String str = "Programming";
        Object o = entityManager.createQuery("select id from Subject where name like ?1").setParameter(1,str).getSingleResult();
        long id = Integer.parseInt(o.toString());
        System.out.println(id);

        Subject subject = entityManager.find(Subject.class,id);
        System.out.println(subject.getName());*/

      /*  String testDate = "29/05/2010";
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = formatter.parse(testDate);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/


        /*Time time = new Time(9,46,33);
        System.out.println(time);*/

        /*System.out.print("Enter group: ");
            String group = scanner.nextLine();
            Object obj1 = entityManager.createQuery("from GroupP where name like ?1").setParameter(1,group).getSingleResult();
            GroupP groupP = (GroupP)obj1;
            System.out.println(groupP.getFaculty().getName());*/