package com.example.lab03.db;

public class User {
    private int id;
    private String name;
    private String surname;
    private int age;
    private University university;

    public User() {}

    public User(int id, String name, String surname, int age, University university) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.university = university;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
