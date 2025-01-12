package org.ulysse.collabtaskapp;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class HelloController {

    @FXML
    private TabPane tabPane;

    @FXML
    protected void onCalendarClick() {
        addTab("Calendar");
    }

    @FXML
    protected void onPersonalManagementClick() {
        addTab("Personal Management");
    }

    @FXML
    protected void onKanbanBoardClick() {
        addTab("Kanban Board");
    }

    private void addTab(String tabName) {
        // Check if a tab with the same name already exists
        for (Tab tab : tabPane.getTabs()) {
            if (tab.getText().equals(tabName)) {
                tabPane.getSelectionModel().select(tab);
                return;
            }
        }

        // Create a new tab
        Tab newTab = new Tab(tabName);
        newTab.setClosable(true); // Allow closing the tab
        tabPane.getTabs().add(newTab);
        tabPane.getSelectionModel().select(newTab);
    }
}
