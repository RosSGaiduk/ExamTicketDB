package com.exam.ua.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Entity
public class Subject implements Comparable<Subject>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_subject",joinColumns = @JoinColumn(name ="id_subject"),
    inverseJoinColumns = @JoinColumn(name = "id_teacher"))
    private Set<Teacher> teachers = new TreeSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "group_subject",joinColumns = @JoinColumn(name = "id_subject"),
    inverseJoinColumns = @JoinColumn(name = "id_group")
    )
    private Set<GroupP> groupPs = new TreeSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "faculty_subject",joinColumns = @JoinColumn(name = "id_subject"),
    inverseJoinColumns = @JoinColumn(name = "id_faculty")
    )
    private Set<Faculty> faculties = new TreeSet<>();


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

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<ExamForGroup> getExamForGroupList() {
        return examForGroupList;
    }

    public void setExamForGroupList(List<ExamForGroup> examForGroupList) {
        this.examForGroupList = examForGroupList;
    }

    public Set<GroupP> getGroupPs() {
        return groupPs;
    }

    public void setGroupPs(Set<GroupP> groupPs) {
        this.groupPs = groupPs;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public int compareTo(Subject o) {
        int compare = this.name.compareTo(o.getName());
        return compare;
    }
}
