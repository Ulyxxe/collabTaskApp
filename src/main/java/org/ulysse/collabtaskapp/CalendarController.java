package org.ulysse.collabtaskapp;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CalendarController {

    @FXML
    private DatePicker datePicker;
    @FXML
    private ListView<String> projectsListView;

    private Map<LocalDate, String> projectDueDates = new HashMap<>();




    @FXML
    public void handleDateSelection() {
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate != null) {
            updateProjectsForSelectedDate(selectedDate);
        }}


    private void updateProjectsForSelectedDate(LocalDate selectedDate) {
        String projectInfo = projectDueDates.get(selectedDate);
        if (projectInfo != null) {

            projectsListView.setItems(FXCollections.observableArrayList(projectInfo));
        } else {

            projectsListView.setItems(FXCollections.observableArrayList("No projects due on this date."));
        }
    }


    public void addProjectDueDate(LocalDate date, String projectName) {
        projectDueDates.put(date, projectName);
    }
}
