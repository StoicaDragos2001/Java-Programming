package com.proiectpa.ridesharing.controller;


import com.proiectpa.ridesharing.ControlPanel;
import com.proiectpa.ridesharing.database.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
/**
 * we verify if the information about rides is correct and redirect the user to Show Rides Page to see rides which correspond to the information requested by him
 * @author Petrea Daniela and Stoica Dragos
 * Class Finding Controller
 */
public class FindingController implements Initializable {
    @FXML
    private ComboBox from;
    @FXML
    private ComboBox to;
    @FXML
    private DatePicker when;
    @FXML
    private ComboBox seats;
    @FXML
    private Button search;
    @FXML
    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> cities = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select city from Romanian_cities order by city");
            while (rs.next()) {
                String city = rs.getString("city");
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        from.getItems().addAll(cities);
        to.getItems().addAll(cities);
        seats.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                java.sql.Connection connection = Database.getConnection();
                CallableStatement call = null;
                String result = "";
                try {
                    call = connection.prepareCall("{ ? = call verify_find_page(?) }");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    call.registerOutParameter(1, Types.VARCHAR);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    call.setString(2, String.valueOf(Date.valueOf(when.getValue())));
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
                    String username=null;
                    try (Statement stmt = connection.createStatement()) {
                        ResultSet rs = stmt.executeQuery("select username from UsersTable where connected='1'");
                        while (rs.next()) {
                            username = rs.getString("username");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        ControlPanel.changeSceneToRides(actionEvent, "showRidesController.fxml", "ShowRides",username,String.valueOf(from.getSelectionModel().getSelectedItem()),String.valueOf(to.getSelectionModel().getSelectedItem()),String.valueOf(Date.valueOf(when.getValue())),String.valueOf(seats.getSelectionModel().getSelectedItem()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(result);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(result);
                    alert.show();
                }
            }
        });
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = null;
                java.sql.Connection connection = Database.getConnection();
                try (Statement stmt = connection.createStatement()) {
                    ResultSet rs = stmt.executeQuery("select username from UsersTable where connected='1'");
                    while (rs.next()) {
                        username = rs.getString("username");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                PreparedStatement ps = null;
                try {
                    ps = connection.prepareStatement(
                            "UPDATE UsersTable SET connected = 0 WHERE username = ?");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    ps.setString(1, username);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    ResultSet resultSet = ps.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    ControlPanel.changeScene(actionEvent, "landingController.fxml", "Landing", null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
