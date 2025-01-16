package org.ulysse.collabtaskapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.ulysse.collabtaskapp.db.EmployeeDAO;
import org.ulysse.collabtaskapp.db.ProjectDAO;
import org.ulysse.collabtaskapp.db.TaskDAO;

import java.sql.Date;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("projectmanagerview.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
            stage.setTitle("Collaborative Application");
            stage.setScene(scene);
            stage.show();

            EmployeeDAO employee2 = new EmployeeDAO();
            EmployeeDAO.addEmployee("jean", "Engineer");
            List<Employee> employees = employee2.getAllEmployees();
            employees.forEach(employee -> System.out.println(employee.getName() + " - " + employee.getRole()));
            Employee employee = employee2.getEmployeeById(1);
            employee.listProjectHistory();
            employee2.addProjectToEmployee(1, 101);


            ProjectDAO projectDAO = new ProjectDAO();
            EmployeeDAO employeeDAO = new EmployeeDAO();
            TaskDAO taskDAO = new TaskDAO();



            projectDAO.addProject("Project A", Date.valueOf("2025-02-01"));

            employeeDAO.addEmployee("thomas","student");
            employeeDAO.addEmployee("Clément", "Test");
            employeeDAO.addProjectToEmployee(1, 1); // Assuming employee_id=1 and project_id=1
            employeeDAO.addProjectToEmployee(2, 1);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();




    }
}
