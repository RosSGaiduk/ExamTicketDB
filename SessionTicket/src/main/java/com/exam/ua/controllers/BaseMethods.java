package com.exam.ua.controllers;

import java.io.UnsupportedEncodingException;

/**
 * Created by Rostyslav on 05.11.2016.
 */
public abstract class BaseMethods {
    public String stringUTF_8Encode(String str){
        try {
            str = new String(str.getBytes("ISO-8859-1"),"UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
