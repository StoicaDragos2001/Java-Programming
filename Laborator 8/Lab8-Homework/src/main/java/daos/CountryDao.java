package daos;

import connection.Database;

import java.sql.*;
import java.util.ArrayList;

/**
 * Data Object Class to create and manipulate country in database
 */
public class CountryDao {

    /**
     * Method to create a country in the database
     * @param name name of the country
     * @param continentId id of the continent in which the country is found
     * @throws SQLException
     */
    public void create(String name, int continentId) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (name,code) values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2,continentId);
            pstmt.executeUpdate();
        }
    }

    /**
     * method that prints a continent
     * @param continentId the id of the continent
     */
    public void print(int continentId) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select name from countries where code='" + continentId + "'");
            while (rs.next()) {
                String countryName = rs.getString("name");
                System.out.print(countryName+" ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}