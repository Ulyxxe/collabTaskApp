package org.ulysse.collabtaskapp.db;

import org.ulysse.collabtaskapp.Priority;
import org.ulysse.collabtaskapp.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    private static final String URL = "jdbc:postgresql://100.124.127.82:5432/javaProjet";
    private static final String USER = "ulysse";
    private static final String PASSWORD = "Isep2025:!";

    // Add a new project
    public void addProject(String name,Date deadline) {
        String query = "INSERT INTO projects (name, deadline,) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);

            statement.setDate(3, deadline);
            // Enum to string

            statement.executeUpdate();
            System.out.println("Project added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all projects
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT * FROM projects";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                projects.add(new Project(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("deadline").toLocalDate()

                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    // Retrieve a project by ID
    public Project getProjectById(int id) {
        String query = "SELECT * FROM projects WHERE id = ?";
        Project project = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                project = new Project(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("deadline").toLocalDate()
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    // Update a project
    public void updateProject(int id, String name, Date deadline) {
        String query = "UPDATE projects SET name = ?, deadline = ?, WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);

            statement.setDate(3, deadline);

             // Enum to string
            statement.setInt(6, id);

            statement.executeUpdate();
            System.out.println("Project updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a project
    public void deleteProject(int id) {
        String query = "DELETE FROM projects WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Project deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
