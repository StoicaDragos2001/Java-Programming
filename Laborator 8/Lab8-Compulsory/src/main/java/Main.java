import connection.Database;
import daos.ContinentDao;
import daos.CountryDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        Database.createConnection();
        try {
            var continents = new ContinentDao();
            continents.create("Europe",1);
            Database.getConnection().commit();
            var countries = new CountryDao();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();
            //TODO: print all the countries in Europe
            countries.print(europeId);
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }

}
