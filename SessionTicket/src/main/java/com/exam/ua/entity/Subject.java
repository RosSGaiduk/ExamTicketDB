package com.exam.ua.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_subject",joinColumns = @JoinColumn(name ="id_subject"),
    inverseJoinColumns = @JoinColumn(name = "id_teacher"))
    private Set<Teacher> teachers = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "group_subject",joinColumns = @JoinColumn(name = "id_subject"),
    inverseJoinColumns = @JoinColumn(name = "id_group")
    )
    private List<GroupP> groupPs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "faculty_subject",joinColumns = @JoinColumn(name = "id_subject"),
    inverseJoinColumns = @JoinColumn(name = "id_faculty")
    )
    private List<Faculty> faculties;


    @OneToMany(mappedBy = "subject",fetch = FetchType.EAGER)
    private List<ExamForGroup> examForGroupList;


    public Subject(){}

    public Subject(String name) {
        this.name = name;
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

   /* public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }*/

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<GroupP> getGroupPs() {
        return groupPs;
    }

    public void setGroupPs(List<GroupP> groupPs) {
        this.groupPs = groupPs;
    }

    public List<ExamForGroup> getExamForGroupList() {
        return examForGroupList;
    }

    public void setExamForGroupList(List<ExamForGroup> examForGroupList) {
        this.examForGroupList = examForGroupList;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
