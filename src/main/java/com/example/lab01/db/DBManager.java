package com.example.lab01.db;

import java.rmi.StubNotFoundException;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection = null;
    // Insert your data here
    private static final String url = "jdbc:postgresql://localhost:5432/backend_labs?currentSchema=public";
    private static final String user = "postgres";
    private static final String password = "123";

    // Connect to database
    static  {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Postgresql");
        } catch (Exception e) {
            System.out.println("SUKA ERROR");
            System.out.println(e.getMessage());
        }
    }



    public static boolean addStudent(Students student) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO students (id, name, surname, student_group, addmited_year) SELECT " +
                    "VALUE (?, ?, ?, ?, ?)" + "");

            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getSurname());
            statement.setString(4, student.getGroup());
            statement.setString(5, student.getAddmitedYear());

            rows = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rows > 0;
    }

    public static ArrayList<Students> getStudents() {
        ArrayList<Students> students = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT *" +
                    "FROM students");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                students.add(new Students(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("student_group"),
                        resultSet.getString("addmited_year")
                ));
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return students;
    }

    public static ArrayList<Students> getByName(String name) {
        ArrayList<Students> students = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT *" +
                    "FROM students WHERE name = ?");
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                students.add(new Students(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("student_group"),
                        resultSet.getString("addmited_year")
                ));
            }

            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }

    public static ArrayList<Students> getBySurname(String surname) {
        ArrayList<Students> students = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT *" +
                    "FROM students WHERE surname = ?");
            statement.setString(1, surname);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                students.add(new Students(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("student_group"),
                        resultSet.getString("addmited_year")
                ));
            }

            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }
    public static ArrayList<Students> getByGroup(String group) {
        ArrayList<Students> students = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT *" +
                    "FROM students WHERE student_group = ?");
            statement.setString(1, group);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                students.add(new Students(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("student_group"),
                        resultSet.getString("addmited_year")
                ));
            }

            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }
    public static ArrayList<Students> getByYear(String addmitedYear) {
        ArrayList<Students> students = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT *" +
                    "FROM students WHERE addmited_year = ?");
            statement.setString(1, addmitedYear);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                students.add(new Students(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("student_group"),
                        resultSet.getString("addmited_year")
                ));
            }

            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }
}
