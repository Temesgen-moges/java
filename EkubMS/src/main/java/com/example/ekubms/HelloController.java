package com.example.ekubms;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {
    DBcon dbc = new DBcon();
    Connection con = dbc.connMethod();
    @FXML
    private TextField email;

    @FXML
    private Button loginbtn;

    @FXML
    private PasswordField password;

    public HelloController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    protected void loginMethod(ActionEvent event) {
        String se = "select name,password,role from usersinfo where name ='" + email.getText() + "'";
        try {
            ResultSet res = con.createStatement().executeQuery(se);
            while (res.next()) {
                if (email.getText().equals(res.getString(1))) {
                    if (password.getText().equals(res.getString(2))) {
                        if (res.getString(3).equals("admin")) {
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("adminHome.fxml"));
                            Scene scene = new Scene(fxmlLoader.load(), 890, 540);
                            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            window.setTitle("AASTU Ekub");
                            window.setScene(scene);
                            window.show();
                        } else if (res.getString(3).equals("user")) {
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("userHome.fxml"));
                            Scene scene = new Scene(fxmlLoader.load(), 890, 540);
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

}