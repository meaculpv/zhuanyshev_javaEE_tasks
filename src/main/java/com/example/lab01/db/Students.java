package com.example.lab01.db;

public class Students {
    private int id;
    private String name;
    private String surname;
    private String group;
    private String addmitedYear;

    public Students() {
    }

    public Students(String name, String surname, String group, String addmitedYear) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.addmitedYear = addmitedYear;
    }

    public Students(int id, String name, String surname, String group, String addmitedYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.addmitedYear = addmitedYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddmitedYear() {
        return addmitedYear;
    }

    public void setAddmitedYear(String addmitedYear) {
        this.addmitedYear = addmitedYear;
    }
}
