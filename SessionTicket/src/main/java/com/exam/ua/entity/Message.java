package com.exam.ua.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rostyslav on 09.11.2016.
 */
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private User userTo;
    @Column
    private String text;
    @Column
    private Date dateOfMessage;

    public Message(){}

    public Message(User user,User userTo,String text,Date dateOfMessage) {
        this.user = user;
        this.text = text;
        this.userTo = userTo;
        this.dateOfMessage = dateOfMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserFrom() {
        return user;
    }

    public void setUserFrom(User userFrom) {
        this.user = userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateOfMessage() {
        return dateOfMessage;
    }

    public void setDateOfMessage(Date dateOfMessage) {
        this.dateOfMessage = dateOfMessage;
    }
}
