package com.example.lab03.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    private static final String url = "jdbc:postgresql://localhost:5432/backend_labs?currentSchema=public";
    private static final String user = "postgres";
    private static final String password = "123";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Postgresql");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static  boolean addUser(User user) {
        int rows = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (name, surname, age, university_id)" +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setInt(3, user.getAge());
            statement.setInt(4, user.getUniversity().getUniversity_id());

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rows > 0;
    }

    public static boolean addUniversity(University university) {
        int rows = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO universities (university_id, university_name, university_shortname)" +
                    "VALUES (?, ?, ?)");
            statement.setInt(1, university.getUniversity_id());
            statement.setString(2, university.getUniversityName());
            statement.setString(3, university.getUniversityShortName());

            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rows > 0;
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT u.id, u.name, u.surname, u.age, u.university_id, u2.university_name, u2.university_shortname\n" +
                    "FROM users u\n" +
                    "INNER JOIN universities u2 on u2.university_id = u.university_id");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        new University(
                                resultSet.getInt("university_id"),
                                resultSet.getString("university_name"),
                                resultSet.getString("university_shortname")
                        )
                ));
            }

            statement.close();
        } catch (Exception e) {

        }

        return users;
    }

    public static User getUser(int id) {
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT u.id, u.name, u.surname, u.age, u.university_id, u2.university_name, u2.university_shortname\n" +
                    "FROM users u\n" +
                    "INNER JOIN universities u2 on u2.university_id = u.university_id WHERE u.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        new University(
                                resultSet.getInt("university_id"),
                                resultSet.getString("university_name"),
                                resultSet.getString("university_shortname")
                        )
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    public static ArrayList<University> getUniversities() {
        ArrayList<University> universities = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM universities uni");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                universities.add(new University(
                        resultSet.getInt("university_id"),
                        resultSet.getString("university_name"),
                        resultSet.getString("university_shortname")
                ));
            }
            statement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return universities;
    }

    public static University getUniversity(int id) {
        University university = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM universities uni WHERE uni.university_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                university = new University(
                        resultSet.getInt("university_id"),
                        resultSet.getString("university_name"),
                        resultSet.getString("university_shortname")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return university;
    }
}
