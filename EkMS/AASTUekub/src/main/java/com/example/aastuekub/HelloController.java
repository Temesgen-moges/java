package com.example.aastuekub;
import javax.swing.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {
    DBCon dbc = new DBCon();
    Connection con = dbc.connMethod();
    @FXML
    private TextField emailField;

    @FXML
    private Button loginBTN;

    @FXML
    private PasswordField passfield;

    public HelloController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    void loginMtd(ActionEvent event) {
        String se = "select email,password,role from users where email ='" + emailField.getText() + "'";
        System.out.println("query set....");
        try {
            ResultSet res = con.createStatement().executeQuery(se);
            System.out.println("query executed....");

            while (res.next()) {
                if (emailField.getText().equals(res.getString(1))) {
                    System.out.println("name correct....");
                    if (passfield.getText().equals(res.getString(2))) {
                        System.out.println("password correct....");

                        if (res.getString(3).equals("admin")) {
                            System.out.println("is admin....");

                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
                            Scene scene = new Scene(fxmlLoader.load(), 893, 580);
                            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            window.setTitle("AASTU Ekub");
                            window.setScene(scene);
                            window.show();
                        } else if (res.getString(3).equals("user")) {
                            System.out.println("is user....");
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user.fxml"));
                            Scene scene = new Scene(fxmlLoader.load(), 830, 500);
                            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            window.setTitle("AASTU Ekub");
                            window.setScene(scene);
                            window.show();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Username");
                }
            }
        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null,"invalid username");
            e.printStackTrace();
        }

    }

    public void verify(ActionEvent actionEvent) {
    }

    public void cancelVer(ActionEvent actionEvent) {
    }

    public void register(ActionEvent actionEvent) {
    }

    public void cancelReg(ActionEvent actionEvent) {
    }

    public void viewResults(ActionEvent actionEvent) {
    }

    public void logout(ActionEvent actionEvent) {
    }
}