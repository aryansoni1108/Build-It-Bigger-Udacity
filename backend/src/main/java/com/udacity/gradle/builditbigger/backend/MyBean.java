package com.udacity.gradle.builditbigger.backend;

import com.aryan.javajokes.Joker;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        Joker joker=new Joker();
        myData=joker.getJoke();
        return myData;
    }

    public void setData(String data) {

        myData = data;
    }
}