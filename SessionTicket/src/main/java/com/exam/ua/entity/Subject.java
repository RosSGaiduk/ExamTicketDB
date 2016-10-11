package com.exam.ua.entity;

import javax.persistence.*;
import java.util.List;

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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_subject",joinColumns = @JoinColumn(name ="id_subject"),
    inverseJoinColumns = @JoinColumn(name = "id_teacher"))
    private List<Teacher> teachers;


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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

}
