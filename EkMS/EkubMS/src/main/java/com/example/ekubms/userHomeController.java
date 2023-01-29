package com.example.ekubms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class userHomeController {
    @FXML
    private Button logoutbtn;

    @FXML
    private Label resultUser;

    @FXML
    private Button verCancel;

    @FXML
    private DatePicker verDare;

    @FXML
    private Button verifyBtn;

    @FXML
    void cancelVer(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 890, 540);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    @FXML
    void send(ActionEvent event) {

    }
}
