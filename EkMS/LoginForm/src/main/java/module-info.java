module com.example.loginform {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loginform to javafx.fxml;
    exports com.example.loginform;
}