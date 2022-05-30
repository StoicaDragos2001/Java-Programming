module com.example.ridesharing {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.proiectpa.ridesharing to javafx.fxml;
    exports com.proiectpa.ridesharing;
    exports com.proiectpa.ridesharing.database;
    opens com.proiectpa.ridesharing.database to javafx.fxml;
    exports com.proiectpa.ridesharing.thread;
    opens com.proiectpa.ridesharing.thread to javafx.fxml;
    exports com.proiectpa.ridesharing.controller;
    opens com.proiectpa.ridesharing.controller to javafx.fxml;
}