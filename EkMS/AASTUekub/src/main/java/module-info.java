module com.example.aastuekub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.aastuekub to javafx.fxml;
    exports com.example.aastuekub;
}