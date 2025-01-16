package org.ulysse.collabtaskapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class PersonalManagementController {

    @FXML
    private TextField employeeNameField;

    @FXML
    private TextField employeeRoleField;

    @FXML
    private ListView<String> employeeListView;

    private List<Employee> employeeList = new ArrayList<>();

    @FXML
    protected void CreateEmployee() {
        String employeeName = employeeNameField.getText();
        String employeeRole = employeeRoleField.getText();



        Employee newEmployee = new Employee(employeeList.size() + 1, employeeName, employeeRole);
        employeeList.add(newEmployee);
        employeeListView.getItems().add(newEmployee.getName() + " Role: " + newEmployee.getRole());
        employeeNameField.clear();
        employeeRoleField.clear();

    }


}
