package com.example.lab02.db;

import com.example.lab01.db.Students;

import java.sql.*;
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

    public static boolean addCar(Car car) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO cars (name, model, year, volume) " +
                    "VALUES (?, ?, ?, ?)" + "");

            statement.setString(1, car.getName());
            statement.setString(2, car.getModel());
            statement.setString(3, car.getYear());
            statement.setDouble(4, car.getVolume());
            rows = statement.executeUpdate();
            System.out.println("Added succesfully");
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rows > 0;
    }

    public static ArrayList<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT *" +
                    "FROM cars");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cars.add(new Car(
                        resultSet.getString("name"),
                        resultSet.getString("model"),
                        resultSet.getString("year"),
                        resultSet.getDouble("volume")
                ));
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return cars;
    }
    public static Car getCar(String model) {
        Car car = new Car();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT *" +
                    "FROM cars WHERE model = ?");
            statement.setString(1, model);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                car = new Car(
                        resultSet.getString("name"),
                        resultSet.getString("model"),
                        resultSet.getString("year"),
                        resultSet.getDouble("volume")
                );
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return car;
    }

    public static boolean saveCar(Car car) {
        int rows = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE cars SET name = ?, year = ?, volume = ? " +
                    "WHERE model = ?");
            System.out.println("HAHA\tservlet");
            statement.setString(1, car.getName());
            statement.setString(2, car.getYear());
            statement.setDouble(3, car.getVolume());
            statement.setString(4, car.getModel());
            rows = statement.executeUpdate();
            System.out.println("Updated successfully");

            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rows > 0;
    }

    public static boolean deleteCar(Car car) {
        int rows = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM cars " +
                    "WHERE model = ?");
            System.out.println(car.getModel());
            statement.setString(1, car.getModel());
            rows = statement.executeUpdate();
            System.out.println("Deleted successfully");

            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rows > 0;
    }
}
