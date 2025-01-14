package org.ulysse.collabtaskapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

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
