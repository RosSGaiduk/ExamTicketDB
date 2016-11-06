package com.exam.ua.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Entity
public class Faculty implements Comparable<Faculty>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String urlImage;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "faculty_subject",joinColumns = @JoinColumn(name = "id_faculty"),
        inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    private Set<Subject> subjects = new TreeSet<>();

    @OneToMany(mappedBy = "faculty",fetch = FetchType.EAGER)
    private List<GroupP> groups;

    @OneToMany(mappedBy = "faculty",fetch = FetchType.EAGER)
    private Set<Teacher> teachers = new TreeSet<>();

    @OneToMany(mappedBy = "faculty",fetch = FetchType.EAGER)
    private Set<ExamForGroup> examForGroupSet = new TreeSet<>();

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

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Set<ExamForGroup> getExamForGroupSet() {
        return examForGroupSet;
    }

    public void setExamForGroupSet(Set<ExamForGroup> examForGroupList) {
        this.examForGroupSet = examForGroupList;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public int compareTo(Faculty o) {
        return this.getName().compareTo(o.getName());
    }
}
