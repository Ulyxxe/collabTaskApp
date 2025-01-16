package org.ulysse.collabtaskapp.db;

import org.ulysse.collabtaskapp.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println("Fetche d tasks for status " + status + ": " + tasks);
        return tasks;;
    }

    public void addTask(String title, String description, Date deadline, String status, String priority) {
        String query = "INSERT INTO tasks (title, description, deadline, status, priority) VALUES (?, ?, ?, ?::task_status, ?:task_priority)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, title);
            statement.setString(2, description);
            statement.setDate(3, deadline);
            statement.setString(4, status);
            statement.setString(5, priority);

            statement.executeUpdate();
            System.out.println("Task added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Map<String, List<Task>> getTasksGroupedByStatus() {
        Map<String, List<Task>> tasksByStatus = new HashMap<>();
        String query = "SELECT * FROM tasks";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String status = resultSet.getString("status");
                Task task = new Task(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("deadline"),
                        resultSet.getString("status"),
                        resultSet.getString("priority")
                );

                tasksByStatus.computeIfAbsent(status, k -> new ArrayList<>()).add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasksByStatus;
    }

}



