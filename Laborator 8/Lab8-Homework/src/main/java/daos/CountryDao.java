package daos;

import connection.Database;

import java.sql.*;
import java.util.ArrayList;

public class CountryDao {

    public void create(String name, int continentId) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (name,code) values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2,continentId);
            pstmt.executeUpdate();
        }
    }

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
