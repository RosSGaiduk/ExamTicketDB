package com.exam.ua.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Rostyslav on 08.10.2016.
 */
@Entity
public class Teacher implements Comparable<Teacher>{
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
    private String seat; //посада

    @ManyToOne(fetch = FetchType.EAGER)
    private Faculty faculty;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_subject",joinColumns = @JoinColumn(name = "id_teacher"),
            inverseJoinColumns = @JoinColumn(name = "id_subject"))
    private Set<Subject> subjects = new TreeSet<>();

    @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
    private Set<ExamForGroup> exams = new TreeSet<>();

    public Teacher(){}

    public Teacher(String name, String lastName, int age, String seat) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.seat = seat;
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

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

/*    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }*/

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Faculty getFaculty() {
        return faculty;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Set<ExamForGroup> getExams() {
        return exams;
    }

    public void setExams(Set<ExamForGroup> exams) {
        this.exams = exams;
    }

    @Override
    public int compareTo(Teacher o) {
        int compare = this.lastName.compareTo(o.getLastName());
        if (compare == 0){
            compare = this.name.compareTo(o.getName());
            if (compare == 0){
                compare = this.seat.compareTo(o.getSeat());
                if (compare == 0){
                    compare = this.age - o.getAge();
                }
            }
        }
        return compare;
    }
}
