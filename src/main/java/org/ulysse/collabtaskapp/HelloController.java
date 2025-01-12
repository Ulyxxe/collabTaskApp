package org.ulysse.collabtaskapp;

import javafx.application.Platform;
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
