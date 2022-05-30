package com.proiectpa.ridesharing.controller;
import com.proiectpa.ridesharing.ControlPanel;
import com.proiectpa.ridesharing.database.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * the user who plans to make a ride in the future enters information about ride in the application
 * @author Petrea Daniela and Stoica Dragos
 * @see Class OfferARideController
 */
public class OfferARideController implements Initializable {
    @FXML
    private ComboBox from;
    @FXML
    private ComboBox to;
    @FXML
    private DatePicker when;
    @FXML
    private ComboBox seats;
    @FXML
    private TextField price;
    @FXML
    private Button submit;

    /**
     * we verify if rides information is correct and insert into RidesTable and redirect user to Landing page
     * @param url
     * @param resourceBundle
     */
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
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                java.sql.Connection connection = Database.getConnection();
                CallableStatement call = null;
                String result = "";
                try {
                    call = connection.prepareCall("{ ? = call verify_offer_page(?,?) }");
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
                    call.setString(3, price.getText());
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
                    try {
                        int wantedId = 0;
                        try (Statement stmt = connection.createStatement()) {
                            ResultSet rs = stmt.executeQuery("select max(rideIndex) from RidesTable");
                            while (rs.next()) {
                                wantedId = rs.getInt("max(rideIndex)");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        wantedId += 1;
                        String username = null;
                        try (Statement stmt = connection.createStatement()) {
                            ResultSet rs = stmt.executeQuery("select username from UsersTable where connected='1'");
                            while (rs.next()) {
                                username = rs.getString("username");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        String phoneNumber = null;
                        try (Statement stmt = connection.createStatement()) {
                            ResultSet rs = stmt.executeQuery("select phoneNumber from UsersTable where username='" + username + "'");
                            while (rs.next()) {
                                phoneNumber = rs.getString("phoneNumber");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        PreparedStatement psInsert = connection.prepareStatement("insert into RidesTable (rideIndex,username,phoneNumber,fromRide,toRide,whenRide,noSeats,price) VALUES(?,?,?,?,?,?,?,?)");
                        psInsert.setInt(1, wantedId);
                        psInsert.setString(2, username);
                        psInsert.setString(3, phoneNumber);
                        psInsert.setString(4, String.valueOf(from.getSelectionModel().getSelectedItem()));
                        psInsert.setString(5, String.valueOf(to.getSelectionModel().getSelectedItem()));
                        psInsert.setString(6,String.valueOf(Date.valueOf(when.getValue())));
                        psInsert.setString(7, String.valueOf(seats.getSelectionModel().getSelectedItem()));
                        psInsert.setString(8, price.getText());
                        psInsert.executeUpdate();
                        ControlPanel.changeScene(actionEvent, "landingController.fxml", "Landing", username);
                    } catch (IOException | SQLException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println(result);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(result);
                    alert.show();
                }
            }
        });
    }


}
