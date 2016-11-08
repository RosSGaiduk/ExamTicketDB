package com.exam.ua.entity;

import javax.persistence.*;

/**
 * Created by Rostyslav on 07.11.2016.
 */
@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String information;
    @Column
    private String urlImage;
    @Column
    private String urlImage1;
    @Column
    private String urlImage2;
    @Column
    private String urlImage3;


    public University(){}

    public University(String name, String information, String urlImage) {
        this.name = name;
        this.information = information;
        this.urlImage = urlImage;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUrlImage1() {
        return urlImage1;
    }

    public void setUrlImage1(String urlImage1) {
        this.urlImage1 = urlImage1;
    }

    public String getUrlImage2() {
        return urlImage2;
    }

    public void setUrlImage2(String urlImage2) {
        this.urlImage2 = urlImage2;
    }

    public String getUrlImage3() {
        return urlImage3;
    }

    public void setUrlImage3(String urlImage3) {
        this.urlImage3 = urlImage3;
    }

}
