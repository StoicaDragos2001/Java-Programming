package com.proiectpa.ridesharing.controller;


import com.proiectpa.ridesharing.ControlPanel;
import com.proiectpa.ridesharing.database.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * the page where a new user creates an account
 * @author Petrea Daniela and Stoica Dragos
 * Class SignUpController
 */
public class SignUpController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField password;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonSignUp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ControlPanel.changeScene(actionEvent, "loginController.fxml", "Login", null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        buttonSignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                java.sql.Connection connection = Database.getConnection();
                CallableStatement call = null;
                String result = "";
                try {
                    call = connection.prepareCall("{ ? = call verify_corectitude(?,?,?) }");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    call.registerOutParameter(1, Types.VARCHAR);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    call.setString(2, username.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    call.setString(3, password.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    call.setString(4, phoneNumber.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    call.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    result = call.getString(1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (result.equals("Everything is correct")) {
                    connection = Database.getConnection();
                    PreparedStatement ps = null;
                    try {
                        ps = connection.prepareStatement(
                                "UPDATE UsersTable SET connected = 1 WHERE username = ?");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        ps.setString(1, username.getText());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        ResultSet resultSet = ps.executeQuery();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    ControlPanel.signUpUser(actionEvent, username.getText(), password.getText(), phoneNumber.getText());
                }  else {
                    System.out.println(result);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(result);
                    alert.show();
                }
            }
        });
    }
}