package com.exam.ua.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostyslav on 21.10.2016.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date birthDate;
    @Column
    private String email;
    @Column
    private String password;
    @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Message> messages;

    @OneToMany(mappedBy = "userTo",fetch = FetchType.EAGER)
    private List<Message> messagesUserTo;

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessagesUserTo() {
        return messagesUserTo;
    }

    public void setMessagesUserTo(List<Message> messagesUserTo) {
        this.messagesUserTo = messagesUserTo;
    }
}
