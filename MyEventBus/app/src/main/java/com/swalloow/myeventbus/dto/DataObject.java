package com.swalloow.myeventbus.dto;

/**
 * Created by Junyoung on 2016-07-08.
 */
public class DataObject {

    private String name;
    private String email;

    public DataObject(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "TestObject{" + "name='" + name + '\'' +
                ", email='" + email + '\'' + '}';
    }
}
