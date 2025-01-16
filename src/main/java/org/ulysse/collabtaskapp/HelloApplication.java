package org.ulysse.collabtaskapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.ulysse.collabtaskapp.db.EmployeeDAO;

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
            employee2.addEmployee("jean", "Engineer");
            List<Employee> employees = employee2.getAllEmployees();
            employees.forEach(employee -> System.out.println(employee.getName() + " - " + employee.getRole()));
            Employee employee = employee2.getEmployeeById(1);
            employee.listProjectHistory();
            employee2.addProjectToEmployee(1, 101);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();




    }
}
