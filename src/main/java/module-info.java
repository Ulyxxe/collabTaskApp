module org.ulysse.collabtaskapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.ulysse.collabtaskapp to javafx.fxml;
    exports org.ulysse.collabtaskapp;
}