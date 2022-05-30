package com.proiectpa.ridesharing.thread;

import com.proiectpa.ridesharing.database.Database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * We have a daemon thread deleting from the database columns that are no longer useful
 * @author Petrea Daniela and Stoica Dragos
 * @see Class DaemonThread
 */
public class DaemonThread extends Thread {
    public DaemonThread(String name) {
        super(name);
    }
    public void run() {
        while (true) {
            Connection connection = Database.getConnection();
            int deleted = 0;
            try {
                deleted = connection.createStatement().executeUpdate("delete from RidesTable where to_date(whenRide,'YYYY-MM-DD')<sysdate-10");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (deleted == 0) {
                System.out.println("Nothing to delete!");
            } else {
                System.out.println("Deleted old rides from the database!");
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}