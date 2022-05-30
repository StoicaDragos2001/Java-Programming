package com.proiectpa.ridesharing.controller;
import com.proiectpa.ridesharing.ControlPanel;
import com.proiectpa.ridesharing.database.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * we display the matching rides with the information from the Find page
 * @author Petrea Daniela and Stoica Dragos
 * Class ShowRidesController
 */
public class ShowRidesController implements Initializable {
    @FXML
    private Button button;
    @FXML
    private ListView<String> resultsList;
    @FXML
    private Label toLabel;
    @FXML
    private Label fromLabel;
    @FXML
    private Label whenLabel;
    @FXML
    private Label seatsLabel;

    /**
     * we are trying to make a match in the database with the information from the find page
     * and display it in a listview
     */
    public void ourInitialization() {
        java.sql.Connection connection = Database.getConnection();
        String fromRideLabel = fromLabel.getText();
        String toRideLabel = toLabel.getText();
        String whenRideLabel = whenLabel.getText();
        String seatsRideLabel = seatsLabel.getText();
        String usernameQuery, phoneNumberQuery, fromRideQuery, toRideQuery, whenRideQuery, noSeatsQuery,priceQuery;
        List<String> usernameArray = new ArrayList<>();
        List<String> phoneNumberArray = new ArrayList<>();
        List<String> fromRideArray = new ArrayList<>();
        List<String> toRideArray = new ArrayList<>();
        List<String> whenRideArray = new ArrayList<>();
        List<String> noSeatsArray = new ArrayList<>();
        List<String> priceArray = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select username,phoneNumber,fromRide,toRide,whenRide,noSeats,price from RidesTable where fromRide='" + fromRideLabel + "' and toRide='" + toRideLabel + "' and whenRide='" + whenRideLabel + "' and noSeats>='" + seatsRideLabel + "'");
            while (rs.next()) {
                usernameQuery = rs.getString("username");
                phoneNumberQuery = rs.getString("phoneNumber");
                fromRideQuery = rs.getString("fromRide");
                toRideQuery = rs.getString("toRide");
                whenRideQuery = rs.getString("whenRide");
                noSeatsQuery = rs.getString("noSeats");
                priceQuery=rs.getString("price");
                usernameArray.add(usernameQuery);
                phoneNumberArray.add(phoneNumberQuery);
                fromRideArray.add(fromRideQuery);
                toRideArray.add(toRideQuery);
                whenRideArray.add(whenRideQuery);
                noSeatsArray.add(noSeatsQuery);
                priceArray.add(priceQuery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int indexArray=0;indexArray<usernameArray.size();indexArray++){
            String result="          "+usernameArray.get(indexArray)+"   |   "+phoneNumberArray.get(indexArray)+"   |   "+fromRideArray.get(indexArray)+"   |   "+toRideArray.get(indexArray)+"   |   "+whenRideArray.get(indexArray)+"   |   "+noSeatsArray.get(indexArray)+" seats   |   "+priceArray.get(indexArray)+" lei";
            resultsList.getItems().add(result);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button.setOnAction(actionEvent -> {
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
        });

    }

    public void setLabelText(String from, String to, String when, String seats) {
        fromLabel.setText(from);
        toLabel.setText(to);
        whenLabel.setText(when);
        seatsLabel.setText(seats);
        ourInitialization();
    }
}
