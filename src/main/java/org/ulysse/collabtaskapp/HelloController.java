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
        addTab("Calendar", "Calendar.fxml");
    }

    @FXML
    protected void onPersonalManagementClick() {
        addTab("Personal Management", "PersonalManagement.fxml");
    }

    @FXML
    protected void onKanbanBoardClick() {
        addTab("Kanban Board", "KanbanBoard.fxml");
    }

    @FXML
    protected void onReportClick() {
        addTab("Report", "Report.fxml");
    }

    @FXML
    protected void onQuitClick() {
        Platform.exit();
    }

    private void addTab(String tabName, String fxmlFile) {
        // Check if the tab already exists
        for (Tab tab : tabPane.getTabs()) {
            if (tab.getText().equals(tabName)) {
                tabPane.getSelectionModel().select(tab);
                return;
            }
        }

        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Create a new tab and set its content
            Tab newTab = new Tab(tabName);
            newTab.setContent(root);
            newTab.setClosable(true);

            // Add the tab to the TabPane
            tabPane.getTabs().add(newTab);
            tabPane.getSelectionModel().select(newTab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
