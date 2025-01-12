package org.ulysse.collabtaskapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("projectmanagerview.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
            stage.setTitle("Collaborative Application");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
