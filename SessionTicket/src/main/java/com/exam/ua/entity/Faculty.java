package com.exam.ua.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String urlImage;

    @OneToMany(mappedBy = "faculty",fetch = FetchType.EAGER)
    private List<GroupP> groups;

    @OneToMany(mappedBy = "faculty",fetch = FetchType.EAGER)
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "faculty",fetch = FetchType.LAZY)
    private List<ExamForGroup> examForGroupList;

    public Faculty(){}

    public Faculty(String name) {
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

    public List<GroupP> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupP> groups) {
        this.groups = groups;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<ExamForGroup> getExamForGroupList() {
        return examForGroupList;
    }

    public void setExamForGroupList(List<ExamForGroup> examForGroupList) {
        this.examForGroupList = examForGroupList;
    }
}
