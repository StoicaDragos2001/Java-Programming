package com.proiectpa.ridesharing.controller;
import com.proiectpa.ridesharing.ControlPanel;
import com.proiectpa.ridesharing.database.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
/**
 * the page where the user who already has an account logs in with his credentials
 * @author Petrea Daniela and Stoica Dragos
 * Class LoginController
 */
public class LoginController implements Initializable {
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonSignUp;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonLogin.setOnAction(actionEvent -> {
            java.sql.Connection connection = Database.getConnection();
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
            ControlPanel.logInUser(actionEvent, username.getText(), password.getText());
        });
        buttonSignUp.setOnAction(actionEvent -> {
            try {
                ControlPanel.changeScene(actionEvent, "signUpController.fxml", "Sign Up", null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}