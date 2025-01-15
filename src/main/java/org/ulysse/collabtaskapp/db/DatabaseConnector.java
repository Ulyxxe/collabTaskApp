package org.ulysse.collabtaskapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {

    // Database URL, username, and password
    private static final String URL = "jdbc:postgresql://100.124.127.82:5432/javaProjet";
    private static final String USER = "ulysse";
    private static final String PASSWORD = "Isep2025:!";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to PostgreSQL database!");

            // Example query: retrieve all tasks
            String query = "SELECT * FROM tasks";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Task: " + resultSet.getString("title"));
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to PostgreSQL database");
            e.printStackTrace();
        }
    }
}
