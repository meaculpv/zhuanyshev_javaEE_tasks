package com.example.lab03.db;

public class University {
    private int university_id;
    private String universityName;
    private String universityShortName;

    public University() {}

    public University(int university_id, String universityName, String universityShortName) {
        this.university_id = university_id;
        this.universityName = universityName;
        this.universityShortName = universityShortName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityShortName() {
        return universityShortName;
    }

    public void setUniversityShortName(String universityShortName) {
        this.universityShortName = universityShortName;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }
}
