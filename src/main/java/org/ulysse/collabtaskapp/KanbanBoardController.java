package org.ulysse.collabtaskapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.ulysse.collabtaskapp.db.TaskDAO;

import java.util.List;

public class KanbanBoardController {

    @FXML
    private VBox toDoColumn;

    @FXML
    private VBox inProgressColumn;

    @FXML
    private VBox doneColumn;

    public void initialize() {
        TaskDAO taskDAO = new TaskDAO();

        // Fetch tasks grouped by status
        List<Task> toDoTasks = taskDAO.getTasksByStatus("TO_DO");
        List<Task> inProgressTasks = taskDAO.getTasksByStatus("IN_PROGRESS");
        List<Task> doneTasks = taskDAO.getTasksByStatus("DONE");

        // Populate each column
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
}
