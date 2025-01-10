package org.ulysse.collabtaskapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onPersonalApplicationClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}