package com.exam.ua.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Entity
public class GroupP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;

    @Column
    private String nameFacultyPattern;
    @ManyToOne(fetch = FetchType.EAGER)
    private Faculty faculty;

    @OneToMany(mappedBy = "groupP",fetch = FetchType.LAZY)
    private List<StudentOfLnu> students;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "group_subject",joinColumns = @JoinColumn(name = "id_group"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    private List<Subject> subjects;
    @OneToMany(mappedBy = "groupP",fetch = FetchType.LAZY)
    private List<ExamForGroup> examForGroupList;

    public GroupP(){}

    public GroupP(String name) {
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
        setNameFacultyPattern(faculty.getName());
    }

    public List<StudentOfLnu> getStudents() {
        return students;
    }

    public void setStudents(List<StudentOfLnu> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<ExamForGroup> getExamForGroupList() {
        return examForGroupList;
    }

    public void setExamForGroupList(List<ExamForGroup> examForGroupList) {
        this.examForGroupList = examForGroupList;
    }

    public String getNameFacultyPattern() {
        return nameFacultyPattern;
    }

    public void setNameFacultyPattern(String nameFacultyPattern) {
        this.nameFacultyPattern = nameFacultyPattern;
    }
}