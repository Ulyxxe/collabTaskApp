package org.ulysse.collabtaskapp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;

public class HelloController {

    @FXML
    private TabPane tabPane;

    @FXML
    protected void onCalendarClick() {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Calendar.fxml"));
            // Optional: Set the controller if it's not automatically found


            // Load the FXML into a Parent node
            Parent root = loader.load();

            // Create a new tab to display the Kanban board
            Tab kanbanTab = new Tab("Kanban Board");
            kanbanTab.setContent(root);  // Set the loaded FXML as the content of the tab

            // Assuming you're adding this tab to a TabPane
            tabPane.getTabs().add(kanbanTab);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onPersonalManagementClick() {
        addTab("Personal Management");
    }

    @FXML
    protected void onKanbanBoardClick() {

        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("KanbanBoard.fxml"));
            // Optional: Set the controller if it's not automatically found


            // Load the FXML into a Parent node
            Parent root = loader.load();

            // Create a new tab to display the Kanban board
            Tab kanbanTab = new Tab("Kanban Board");
            kanbanTab.setContent(root);  // Set the loaded FXML as the content of the tab

            // Assuming you're adding this tab to a TabPane
            tabPane.getTabs().add(kanbanTab);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onQuitClick() {

        Platform.exit();
    }

    private void addTab(String tabName) {

        for (Tab tab : tabPane.getTabs()) {
            if (tab.getText().equals(tabName)) {
                tabPane.getSelectionModel().select(tab);
                return;
            }
        }

        Tab newTab = new Tab(tabName);
        newTab.setClosable(true);
        tabPane.getTabs().add(newTab);
        tabPane.getSelectionModel().select(newTab);
    }
}
