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

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Calendar.fxml"));



            Parent root = loader.load();


            Tab calendarTab = new Tab("Calendar");
            calendarTab.setContent(root);


            tabPane.getTabs().add(calendarTab);

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

            FXMLLoader loader = new FXMLLoader(getClass().getResource("KanbanBoard.fxml"));

            Parent root = loader.load();


            Tab kanbanTab = new Tab("Kanban Board");
            kanbanTab.setContent(root);


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
