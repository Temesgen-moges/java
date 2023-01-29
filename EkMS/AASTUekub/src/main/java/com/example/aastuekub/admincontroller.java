package com.example.aastuekub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.security.spec.ECField;
import java.sql.*;

public class admincontroller {
    DBCon dbc = new DBCon();
    Connection con = dbc.connMethod();
    private Statement st;
    private PreparedStatement prs;

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
    private Button verCancel;

    @FXML
    private DatePicker verDare;

    @FXML
    private TextField veremail;

    @FXML
    private Button verifyBtn;


    public admincontroller() throws SQLException, ClassNotFoundException {
    }



    public void register(ActionEvent actionEvent) {
        String insertion = "insert into users(name,email,phoneno,password,role,adress) values(?,?,?,'1234','user',?)";


        try {
            try {
                prs = con.prepareStatement(insertion);
                prs.setString(1, regName.getText());
                prs.setString(2, regEmail.getText());
                prs.setString(3, regPhoneNo.getText());
                prs.setString(4, regAddress.getText());


//                ResultSet myRs= prs.executeQuery();
                if (prs.execute()) {
                    JOptionPane.showMessageDialog(null,"registration successfull!");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"registration failed!");
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cancelVer(ActionEvent actionEvent) {

        veremail.setText("");

    }

    public void cancelReg(ActionEvent actionEvent) {
    }
    @FXML
    void logout(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
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


    public void verify(ActionEvent actionEvent) {
        System.out.println("in verif...");
        String ins = "insert into payment (email,dateofPayment ) values (?,?)";
        try {
            PreparedStatement pst= con.prepareStatement(ins);

            pst.setString(1,veremail.getText());
            pst.setString(2,verDare.getValue().toString());
            if (pst.execute()){
                JOptionPane.showMessageDialog(null,"Verified successfully!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}