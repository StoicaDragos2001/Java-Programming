package com.proiectpa.ridesharing;
import com.proiectpa.ridesharing.controller.LandingController;
import com.proiectpa.ridesharing.controller.LoginController;
import com.proiectpa.ridesharing.controller.ShowRidesController;
import com.proiectpa.ridesharing.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * the control panel that manage the controllers
 * @author Petrea Daniela and Stoica Dragos
 * @see Class ControlPanel
 */
public class ControlPanel {
    /**
     * @param event on which we have an event listener
     * @param fxmlFile that represents the front page we want to redirect the user
     * @param title name of the page
     * @param username if the user is not connected will be null
     * @throws IOException
     */
    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username) throws IOException {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(ControlPanel.class.getResource(fxmlFile));
            root = loader.load();
            if (fxmlFile.equals("loginController.fxml")) {
                LoginController loginController = loader.getController();
            } else if (fxmlFile.equals("landingController.fxml")) {
                LandingController landingController = loader.getController();
                if (username == null)
                    landingController.setNotUserInformationLanding();
                else
                    landingController.setUserInformationLanding(username);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void changeSceneToRides(ActionEvent event, String fxmlFile, String title, String username, String from, String to, String when, String seats) throws IOException {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(ControlPanel.class.getResource(fxmlFile));
            root = loader.load();
            if (fxmlFile.equals("showRidesController.fxml")) {
                ShowRidesController showRidesController = loader.getController();
                showRidesController.setLabelText(from, to, when, seats);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    /**
     * we verify the credentials of the new user and if it's okay we will insert it into UsersTable
     * @param event on which we have an event listener
     * @param username username of the user who try to connect
     * @param password password of the user who try to connect
     * @param phoneNumber phoneNumber of the user who try to connect
     */
    public static void signUpUser(ActionEvent event, String username, String password, String phoneNumber) {
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExist = null;
        ResultSet resultSet = null;
        java.sql.Connection connection = null;
        try {
            connection = Database.getConnection();
            psCheckUserExist = connection.prepareStatement(
                    "select * from UsersTable where username=?");
            psCheckUserExist.setString(1, username);
            resultSet = psCheckUserExist.executeQuery();
            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("insert into UsersTable (username,userPass,phoneNumber,connected) VALUES(?,?,?,?)");
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.setString(3, phoneNumber);
                psInsert.setInt(4, 1);
                psInsert.executeUpdate();
                FXMLLoader loader = new FXMLLoader(ControlPanel.class.getResource("landingController.fxml"));
                loader.load();
                LandingController landingController = loader.getController();
                landingController.setUserInformationLanding(username);
                changeScene(event, "landingController.fxml", "Landing", username);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * we verify the credentials of the user and if it's okay he will be redirected to Landing page
     * @param event on which we have an event listener
     * @param username username of the user who try to connect
     * @param password password of the user who try to connect
     */
    public static void logInUser(ActionEvent event, String username, String password) {
        java.sql.Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("select userPass from UsersTable where username=?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect!");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("userPass");
                    if (retrievedPassword.equals(password)) {
                        FXMLLoader loader = new FXMLLoader(ControlPanel.class.getResource("landingController.fxml"));
                        loader.load();
                        LandingController landingController = loader.getController();
                        landingController.setUserInformationLanding(username);
                        changeScene(event, "landingController.fxml", "Welcome", username);
                    } else {
                        System.out.println("Passwords didn't match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided credentials are incorrect!");
                        alert.show();
                    }
                }

            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}