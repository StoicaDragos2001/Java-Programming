package daos;

import connection.Database;

import java.sql.*;

/**
 * Data Object Class to create and manipulate continents in database
 */
public class ContinentDao {
    /**
     * Method to create a continent in the database
     * @param name name of the continent
     * @param id id of the continent
     * @throws SQLException
     */
    public void create(String name,int id) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents (name,id) values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
        }
    }

    /**
     * method that finds a continent based on its name
     * @param name string that defines the name of the continent
     * @return id of the continent
     * @throws SQLException
     */
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from continents where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    /**
     * method that finds a continent based on its id
     * @param id integer that defines the id of the continent
     * @return name of the continent
     * @throws SQLException
     */
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from continents where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    /**
     * Method that prints the continent
     */
    public void print()  {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select name from continents");
            while (rs.next()) {
                String continentName = rs.getString("name");
                System.out.print(continentName+" ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}