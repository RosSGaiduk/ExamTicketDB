package com.exam.ua.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Entity
public class StudentOfLnu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private int age;
    @Column
    private int course;
    @Column
    private int mark1;
    @Column
    private int mark2;
    @Column
    private int mark3;
    @Column
    private int mark4;
    @Column
    private String nameFaculty;
    @Column
    private String form; //форма навчання
    @Column
    private boolean hasStudentSalary; //стипендія

    @ManyToOne(fetch = FetchType.LAZY)
    private GroupP groupP;


    public StudentOfLnu(){}

    public StudentOfLnu(String name) {
        this.name = name;
    }

    public StudentOfLnu(String name, String lastName, int age, int course,
                        String form,String nameFaculty) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
        this.form = form;
        this.nameFaculty = nameFaculty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupP getGroupP() {
        return groupP;
    }

    public void setGroupP(GroupP groupP) {
        this.groupP = groupP;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }

    public int getMark4() {
        return mark4;
    }

    public void setMark4(int mark4) {
        this.mark4 = mark4;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public boolean isHasStudentSalary() {
        return hasStudentSalary;
    }

    public void setHasStudentSalary(boolean hasStudentSalary) {
        this.hasStudentSalary = hasStudentSalary;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public void copyField(StudentOfLnu studentOfLnu){
        this.age = studentOfLnu.getAge(); this.name = studentOfLnu.getName();
        this.lastName = studentOfLnu.getLastName(); this.course = studentOfLnu.getCourse();
        this.form = studentOfLnu.getForm(); this.groupP = studentOfLnu.getGroupP();
        //this.nameFaculty = studentOfLnu.getNameFaculty();
    }
}
