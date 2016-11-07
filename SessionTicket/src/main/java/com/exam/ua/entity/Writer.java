package com.exam.ua.entity;

import javax.persistence.*;

/**
 * Created by Rostyslav on 07.11.2016.
 */
@Entity
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String lastName;
    @Column
    private String name;
    @Column
    private String fatherName;
    @Column
    private String biography;
    @Column
    private String urlImage;

    public Writer(){}
    public Writer(String lastName,String name,String fatherName,String biography){
        this.lastName = lastName; this.name = name; this.fatherName = fatherName; this.biography = biography;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
