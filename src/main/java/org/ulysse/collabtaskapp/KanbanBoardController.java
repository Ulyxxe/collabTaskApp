package org.ulysse.collabtaskapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.ulysse.collabtaskapp.db.TaskDAO;

import java.util.List;
import java.util.Optional;

public class KanbanBoardController {

    @FXML
    private VBox toDoColumn;

    @FXML
    private VBox inProgressColumn;

    @FXML
    private VBox doneColumn;

    public void initialize() {
        TaskDAO taskDAO = new TaskDAO();


        List<Task> toDoTasks = taskDAO.getTasksByStatus("TO_DO");
        List<Task> inProgressTasks = taskDAO.getTasksByStatus("IN_PROGRESS");
        List<Task> doneTasks = taskDAO.getTasksByStatus("DONE");


        populateColumn(toDoColumn, toDoTasks);
        populateColumn(inProgressColumn, inProgressTasks);
        populateColumn(doneColumn, doneTasks);
    }

    private void populateColumn(VBox column, List<Task> tasks) {
        if (tasks != null) {
            for (Task task : tasks) {
                Label taskCard = createTaskCard(task);
                column.getChildren().add(taskCard);
            }
        }
    }

    private Label createTaskCard(Task task) {
        Label taskCard = new Label(task.getTitle() + "\n" + task.getDescription() + "\nPriority: " + task.getPriority());
        taskCard.setWrapText(true);
        taskCard.getStyleClass().add("kanban-task");
        return taskCard;
    }
    @FXML
    public void handleCreateNewProject(ActionEvent event) {
        // Implementation for creating a new project
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Create New Project");
        alert.setHeaderText(null);
        alert.setContentText("New project creation functionality is not implemented yet.");
        alert.showAndWait();
    }
    @FXML
    public void handleProjectSelect(ActionEvent event) {
        // Example logic for selecting a project
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Project Selection");
        alert.setHeaderText(null);
        alert.setContentText("You have selected a project!");
        alert.showAndWait();
    }
    @FXML
    public void handleAddTask(ActionEvent event) {
        // Show a dialog to add a new task
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Task");
        dialog.setHeaderText("Create a New Task");
        dialog.setContentText("Enter task title:");


        Optional<String> result = dialog.showAndWait();
        result.ifPresent(taskTitle -> {

            Label newTask = new Label(taskTitle);
            newTask.setWrapText(true);
            newTask.getStyleClass().add("kanban-task");
            toDoColumn.getChildren().add(newTask);


            TaskDAO taskDAO = new TaskDAO();
            taskDAO.addTask(taskTitle, "Description", null, "TO_DO", Priority.MEDIUM, 1);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Task Added");
            alert.setHeaderText(null);
            alert.setContentText("Task \"" + taskTitle + "\" added to 'To Do'!");
            alert.showAndWait();
        });
    }
    @FXML
    public void handleMoveTask(MouseEvent event) {
        Label task = (Label) event.getSource(); // Get the dragged task
        VBox currentColumn = (VBox) task.getParent(); // Get the current column
        VBox targetColumn = determineTargetColumn(currentColumn); // Determine where to move it

        if (targetColumn != null) {

            currentColumn.getChildren().remove(task);
            targetColumn.getChildren().add(task);


            TaskDAO taskDAO = new TaskDAO();
            String newStatus = getColumnStatus(targetColumn);
            taskDAO.updateTaskStatus(task.getText(), newStatus); // Assumes task title is unique


            System.out.println("Task moved to: " + newStatus);
        }
    }

    private VBox determineTargetColumn(VBox currentColumn) {

        if (currentColumn == toDoColumn) {
            return inProgressColumn;
        } else if (currentColumn == inProgressColumn) {
            return doneColumn;
        } else if (currentColumn == doneColumn) {
            return toDoColumn;
        }
        return null;
    }

    private String getColumnStatus(VBox column) {

        if (column == toDoColumn) {
            return "TO_DO";
        } else if (column == inProgressColumn) {
            return "IN_PROGRESS";
        } else if (column == doneColumn) {
            return "DONE";
        }
        return null;
    }
}
