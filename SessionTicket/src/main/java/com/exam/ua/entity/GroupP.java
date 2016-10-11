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

    @ManyToOne(fetch = FetchType.EAGER)
    private Faculty faculty;

    @OneToMany(mappedBy = "groupP",fetch = FetchType.LAZY)
    private List<StudentOfLnu> students;

    public List<StudentOfLnu> getStudents() {
        return students;
    }

    public void setStudents(List<StudentOfLnu> students) {
        this.students = students;
    }

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
    }
}
