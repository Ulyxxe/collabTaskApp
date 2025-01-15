package org.ulysse.collabtaskapp.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    private static final String URL = "jdbc:postgresql://100.124.127.82:5432/javaProjet";
    private static final String USER = "ulysse";
    private static final String PASSWORD = "Isep2025:!";

    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        String query = "SELECT title FROM tasks";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                tasks.add(resultSet.getString("title"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void addTask(String title, String description, Date deadline, String status) {
        String query = "INSERT INTO tasks (title, description, deadline, status) VALUES (?, ?, ?, ?::task_status)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, title);
            statement.setString(2, description);
            statement.setDate(3, deadline);
            statement.setString(4, status);

            statement.executeUpdate();
            System.out.println("Task added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
