package com.exam.ua.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private List<ExamForGroup> exams = new ArrayList<>();

    public SessionOfGroup(){}

    public SessionOfGroup(List<ExamForGroup> exams) {
        this.exams = exams;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ExamForGroup> getExams() {
        return exams;
    }

    public void setExams(List<ExamForGroup> exams) {
        this.exams = exams;
    }
}
