module com.example.ekubms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.ekubms to javafx.fxml;
    exports com.example.ekubms;
}