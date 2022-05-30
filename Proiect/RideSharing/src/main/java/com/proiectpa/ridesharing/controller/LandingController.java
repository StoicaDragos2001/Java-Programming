package com.proiectpa.ridesharing.controller;

import com.proiectpa.ridesharing.ControlPanel;
import com.proiectpa.ridesharing.database.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * main page of the site
 * the user can connect to offer a ride or to see rides
 * @author Petrea Daniela and Stoica Dragos
 * Class LandingController
 */
public class LandingController implements Initializable {
    @FXML
    private Button button;
    @FXML
    private Button offer;
    @FXML
    private Button search;
    @FXML
    private Label username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button.setOnAction(actionEvent -> {
            if(button.getText().equals("Login")) {
                try {
                    ControlPanel.changeScene(actionEvent, "loginController.fxml", "Login", null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                button.setText("Login");
                java.sql.Connection connection = Database.getConnection();
                PreparedStatement ps = null;
                try {
                    ps = connection.prepareStatement(
                            "UPDATE UsersTable SET connected = 0 WHERE username = ?");
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
            }
        });
        offer.setOnAction(actionEvent -> {
            if(button.getText().equals("Login")) {
                try {
                    ControlPanel.changeScene(actionEvent, "loginController.fxml", "Login", null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(button.getText().equals("Logout"))
            {
                FXMLLoader loader = new FXMLLoader(ControlPanel.class.getResource("OfferARideController.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    ControlPanel.changeScene(actionEvent, "offerARideController.fxml", "OfferARide", username.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        search.setOnAction(actionEvent -> {
            if(button.getText().equals("Login")) {
                try {
                    ControlPanel.changeScene(actionEvent, "loginController.fxml", "Login", null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(button.getText().equals("Logout"))
            {
                FXMLLoader loader = new FXMLLoader(ControlPanel.class.getResource("FindingController.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    ControlPanel.changeScene(actionEvent, "FindingController.fxml", "FindingARide", null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    public void setUserInformationLanding(String user) {
        username.setText(user);
        button.setText("Logout");
    }
    public void setNotUserInformationLanding() {
        button.setText("Login");
    }
}