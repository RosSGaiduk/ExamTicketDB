package com.exam.ua.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Rostyslav on 01.11.2016.
 */
@Entity
public class SessionOfGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sessionOfGroup")
    private Set<ExamForGroup> exams = new TreeSet<>();

    public SessionOfGroup(){}

    public SessionOfGroup(Set<ExamForGroup> exams) {
        this.exams = exams;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<ExamForGroup> getExams() {
        return exams;
    }

    public void setExams(Set<ExamForGroup> exams) {
        this.exams = exams;
    }
}
