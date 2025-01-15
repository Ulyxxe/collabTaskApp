package org.ulysse.collabtaskapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KanbanBoardController {

    @FXML
    private VBox todoColumn, inProgressColumn, doneColumn, taskListContainer;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField projectNameField;

    @FXML
    private ComboBox<String> projectSelectComboBox;

    @FXML
    private TextField taskTitleField;
    @FXML
    private TextField taskDescriptionField;
    @FXML
    private DatePicker taskDueDateField;
    @FXML
    private ComboBox<String> taskPriorityField;
    private CalendarController calendarController;

    private List<Project> projects = new ArrayList<>(); // List to store projects
    private Project selectedProject; // Currently selected project

    @FXML
    private void initialize() {

        calendarController = new CalendarController();
    }

    @FXML
    private void handleCreateNewProject() {
        String projectName = projectNameField.getText().trim();
        LocalDate deadline = LocalDate.now();
        if (projectName.isEmpty()) {
            showAlert("Error", "Please enter a valid project name.");
            return;
        }

        // Create a new project and add it to the project list
        Project newProject = new Project(projects.size() + 1, projectName, deadline);
        projects.add(newProject);

        // Update project select combo box
        projectSelectComboBox.getItems().add(newProject.getName());

        showAlert("Success", "Project '" + newProject.getName() + "' created successfully!");

        projectNameField.clear(); // Clear input field after creating the project
    }

    @FXML
    private void handleProjectSelect() {
        String selectedProjectName = projectSelectComboBox.getValue();
        if (selectedProjectName != null) {
            // Find the selected project by name
            selectedProject = projects.stream()
                    .filter(project -> project.getName().equals(selectedProjectName))
                    .findFirst()
                    .orElse(null);

            if (selectedProject != null) {
                displayTasksForProject(); // Display tasks for the selected project
            }
        }
    }

    @FXML
    private void handleAddTask() {
        if (selectedProject != null) {
            // Get the task details from the input fields
            String taskTitle = taskTitleField.getText().trim();
            String taskDescription = taskDescriptionField.getText().trim();
            LocalDate taskDueDate = taskDueDateField.getValue(); // Get the due date from the DatePicker
            Priority taskPriority = Priority.valueOf(taskPriorityField.getValue().toUpperCase()); // Convert to enum

            if (taskTitle.isEmpty() || taskDescription.isEmpty() || taskDueDate == null || taskPriority == null) {
                showAlert("Error", "Please fill in all task fields.");
                return;
            }

            // Generate task ID (just an example, could be based on the project or other logic)
            int taskId = selectedProject.getTasks().size() + 1;

            // Create a new task
            Task newTask = new Task(taskId, taskTitle, taskDescription, Status.TO_DO, taskPriority, taskDueDate, "General");

            // Add the task to the selected project
            selectedProject.addTask(newTask);



            calendarController.addProjectDueDate(taskDueDate, selectedProject.getName());

            // Refresh task list display
            displayTasksForProject();

            // Clear input fields
            taskTitleField.clear();
            taskDescriptionField.clear();
            taskDueDateField.setValue(null);
            taskPriorityField.setValue(null);

            showAlert("Success", "Task '" + newTask.getTitle() + "' added successfully.");
        }
    }

    private void displayTasksForProject() {
        // Clear the existing task list
        taskListContainer.getChildren().clear();

        // List tasks in the To-Do column
        todoColumn.getChildren().clear();
        for (Task task : selectedProject.getTasksByStatus(Status.TO_DO)) {
            Label taskLabel = new Label(task.getTitle());
            todoColumn.getChildren().add(taskLabel);
        }

        // List tasks in the In Progress column
        inProgressColumn.getChildren().clear();
        for (Task task : selectedProject.getTasksByStatus(Status.IN_PROGRESS)) {
            Label taskLabel = new Label(task.getTitle());
            inProgressColumn.getChildren().add(taskLabel);
        }

        // List tasks in the Done column
        doneColumn.getChildren().clear();
        for (Task task : selectedProject.getTasksByStatus(Status.DONE)) {
            Label taskLabel = new Label(task.getTitle());
            doneColumn.getChildren().add(taskLabel);
        }

        statusLabel.setText("Project: " + selectedProject.getName());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
