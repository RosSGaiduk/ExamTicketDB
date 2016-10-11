package com.exam.ua.entity;




import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Rostyslav on 11.10.2016.
 */
@Entity
public class ExamForGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @Column
    private int hour;
    @Column
    private int minute;

    public ExamForGroup(){}

    public ExamForGroup(Date date,int hour,int minute) {
        this.date = date;this.hour = hour; this.minute = minute;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
