package com.example.lab02.db;

public class Car {
    private String name;
    private String model;
    private String year;
    private double volume;

    public Car() {}

    public Car(String name, String model, String year, double volume) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
