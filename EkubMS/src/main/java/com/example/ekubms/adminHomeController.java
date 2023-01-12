package com.example.ekubms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminHomeController {
    DBcon dbc = new DBcon();
    Connection con = dbc.connMethod();
    @FXML
    private TextField regAddress;

    @FXML
    private Button regBtn;

    @FXML
    private Button regCancel;

    @FXML
    private DatePicker regDate;

    @FXML
    private TextField regEmail;

    @FXML
    private TextField regName;

    @FXML
    private TextField regPhoneNo;

    @FXML
    private TextField verAmmount;

    @FXML
    private Button verCancel;

    @FXML
    private DatePicker verDare;

    @FXML
    private TextField veremail;

    @FXML
    private Button verifyBtn;

    public adminHomeController() throws SQLException, ClassNotFoundException {
    }

    public void verify(ActionEvent actionEvent) {
    }

    public void register(ActionEvent actionEvent) {
        String insertion = "insert into usersinfo(name,email,phone,password,role,adress,id) values('"+regName.getText()+"','"+regEmail.getText()+"','"+regPhoneNo.getText()+"','1234','user'.'"+regAddress.getText()+"',8)";


        try{
            ResultSet pst = con.createStatement().executeQuery(insertion);
            while(pst.next())   {
                JOptionPane.showMessageDialog(null,"insertion successfull");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void cancelVer(ActionEvent actionEvent) {
        verAmmount.setText("");
        veremail.setText("");

    }

    public void cancelReg(ActionEvent actionEvent) {
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

    public void viewResults(ActionEvent event) {

    }
}
