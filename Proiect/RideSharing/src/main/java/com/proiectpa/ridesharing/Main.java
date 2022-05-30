package com.proiectpa.ridesharing;
import com.proiectpa.ridesharing.database.Database;
import com.proiectpa.ridesharing.thread.DaemonThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Petrea Daniela and Stoica Dragos
 * Class Main
 */

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("landingController.fxml"));
        stage.setTitle("Landing");
        stage.setScene(new Scene(root,600,400));
        stage.show();
        stage.setOnCloseRequest(
                event -> {
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
                    if(username!=null) {
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
                    }
                });
    }

    public static void main(String[] args) {
        Database.createConnection();
        DaemonThread t1 = new DaemonThread("t1");
        t1.setDaemon(true);
        t1.start();
        launch(args);
    }
}