package org.ulysse.collabtaskapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KanbanBoardController {

    @FXML
    private VBox todoColumn;

    @FXML
    private VBox inProgressColumn;

    @FXML
    private VBox doneColumn;

    @FXML
    private Label statusLabel;
    @FXML
    private TextField projectNameField;

    @FXML
    private DatePicker deadlinePicker;
    @FXML
    private VBox projectListContainer;  // VBox to display the list of projects

    private List<Project> projects = new ArrayList<>();  // List to store projects


    @FXML
    private void handleCreateNewProject() {
        // Get project name and deadline from input fields
        String projectName = projectNameField.getText().trim();
        LocalDate deadline = deadlinePicker.getValue();

        // Validate inputs
        if (projectName.isEmpty() || deadline == null) {
            showAlert("Error", "Please enter a valid project name and deadline.");
            return;
        }

        // Create a new project (ID can be auto-generated as 1 for simplicity)
        Project newProject = new Project(1, projectName, deadline);

        // Show a confirmation alert
        showAlert("Success", "Project '" + newProject.getName() + "' created successfully!");

        // Clear input fields
        projectNameField.clear();
        deadlinePicker.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleAddTask() {
        Label newTask = new Label("New Task");
        todoColumn.getChildren().add(newTask);
        statusLabel.setText("Status: Task added to To-Do");
    }

    @FXML
    private void handleMoveTask() {
        if (!todoColumn.getChildren().isEmpty()) {
            Label task = (Label) todoColumn.getChildren().remove(0);
            inProgressColumn.getChildren().add(task);
            statusLabel.setText("Status: Task moved to In Progress");
        }
    }

    @FXML
    private void handleMoveToDone() {
        if (!inProgressColumn.getChildren().isEmpty()) {
            Label task = (Label) inProgressColumn.getChildren().remove(0);
            doneColumn.getChildren().add(task);
            statusLabel.setText("Status: Task moved to Done");
        }
    }
}
