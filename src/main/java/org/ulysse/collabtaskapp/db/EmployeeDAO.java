package org.ulysse.collabtaskapp.db;

import org.ulysse.collabtaskapp.Employee;
import org.ulysse.collabtaskapp.Priority;
import org.ulysse.collabtaskapp.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private static final String URL = "jdbc:postgresql://100.124.127.82:5432/javaProjet";
    private static final String USER = "ulysse";
    private static final String PASSWORD = "Isep2025:!";

    // Add a new employee
    public static void addEmployee(String name, String role) {
        String query = "INSERT INTO employee (name, role) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setString(2, role);

            statement.executeUpdate();
            System.out.println("Employee added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Employee> getAllEmployees() {
        List<Employee> employee = new ArrayList<>();
        String query = "SELECT * FROM employee";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                employee.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("role")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    // Retrieve an employee by ID (with project history)
    public Employee getEmployeeById(int id) {
        String employeeQuery = "SELECT * FROM employee WHERE id = ?";
        String projectQuery = "SELECT p.id, p.name, p.deadline " +
                "FROM projects p " +
                "JOIN employee_projects ep ON p.id = ep.project_id " +
                "WHERE ep.employee_id = ?";

        Employee employee = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement empStatement = connection.prepareStatement(employeeQuery);
             PreparedStatement projStatement = connection.prepareStatement(projectQuery)) {

            // Fetch employee details
            empStatement.setInt(1, id);
            ResultSet empResult = empStatement.executeQuery();

            if (empResult.next()) {
                employee = new Employee(
                        empResult.getInt("id"),
                        empResult.getString("name"),
                        empResult.getString("role")
                );

                // Fetch project history
                projStatement.setInt(1, id);
                ResultSet projResult = projStatement.executeQuery();

                while (projResult.next()) {
                    Project project = new Project(
                            projResult.getInt("id"),
                            projResult.getString("name"),

                            projResult.getDate("deadline").toLocalDate()
                    );
                    employee.addProjectToHistory(project);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    // Update an employee
    public void updateEmployee(int id, String name, String role) {
        String query = "UPDATE employee SET name = ?, role = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setString(2, role);
            statement.setInt(3, id);

            statement.executeUpdate();
            System.out.println("Employee updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an employee
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Employee deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add a project to an employee's project history
    public void addProjectToEmployee(int employeeId, int projectId) {
        String checkProjectQuery = "SELECT 1 FROM projects WHERE id = ?";
        String insertQuery = "INSERT INTO employee_projects (employee_id, project_id) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement checkStatement = connection.prepareStatement(checkProjectQuery);
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {

            // Check if the project exists
            checkStatement.setInt(1, projectId);
            ResultSet resultSet = checkStatement.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Error: Project with ID " + projectId + " does not exist.");
                return; // Exit without inserting
            }

            // Insert into employee_projects if the project exists
            insertStatement.setInt(1, employeeId);
            insertStatement.setInt(2, projectId);
            insertStatement.executeUpdate();
            System.out.println("Project successfully assigned to employee!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove a project from an employee's project history
    public void removeProjectFromEmployee(int employeeId, int projectId) {
        String query = "DELETE FROM employee_projects WHERE employee_id = ? AND project_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, employeeId);
            statement.setInt(2, projectId);

            statement.executeUpdate();
            System.out.println("Project removed from employee's history!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
