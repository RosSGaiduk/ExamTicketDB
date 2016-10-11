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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
public class Main {
    public static void deleteFaculty(long id){
        List<GroupP> groupPs = entityManager.find(Faculty.class,id).getGroups();
        for (GroupP groupP: groupPs){
            List<StudentOfLnu> studentOfLnus = groupP.getStudents();
            for (int j = 0; j < studentOfLnus.size(); j++){
                entityManager.remove(entityManager.find(StudentOfLnu.class,studentOfLnus.get(j).getId()));
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

        String [] faculties = {"Biologic","Geographic","Geologic","Economical","Electronics","Foreign languages",
            "Historical","Art and Culture", "Mechanics and mathematics","International relations",
            "Teacher's education","Applied mathematics and informatics","Management of finances and business",
                "Physical","Philological","Philosophical","Chemical","Juridical"
        };


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

       /* String testDate = "29/05/2010";
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = formatter.parse(testDate);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/


        Time time = new Time(9,46,33);
        System.out.println(time);


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
