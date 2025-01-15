module org.ulysse.collabtaskapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens org.ulysse.collabtaskapp to javafx.fxml;
    exports org.ulysse.collabtaskapp;
    exports org.ulysse.collabtaskapp.db;
    opens org.ulysse.collabtaskapp.db to javafx.fxml;
}