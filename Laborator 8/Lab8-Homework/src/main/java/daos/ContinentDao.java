package daos;

import connection.Database;

import java.sql.*;

public class ContinentDao {
    public void create(String name,int id) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents (name,id) values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from continents where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from continents where id='" + id + "'")) {
            return rs.next() ? rs.getString(0) : null;
        }
    }
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
