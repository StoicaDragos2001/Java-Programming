package daos;

import connection.Database;

import java.sql.*;

public class CityDao {
    public void create(String name, int id, String country, int capital, String latitude, String longitude) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into cities (name,id,country,capital,latitude,longitude) values (?,?,?,?,?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.setString(3, country);
            pstmt.setInt(4, capital);
            pstmt.setString(5, latitude);
            pstmt.setString(6, longitude);
            pstmt.executeUpdate();
        }
    }

    public void print() {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select name from cities");
            while (rs.next()) {
                String cityName = rs.getString("name");
                System.out.print(cityName + " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void printCapital(String givenCountry) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select name from cities where country='"+givenCountry+"'");
            while (rs.next()) {
                String capitalName = rs.getString("name");
                System.out.print(capitalName + " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getLatitude(String city) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select latitude from cities where name='" + city + "'");
            while (rs.next()) {
                String latitudeCity = rs.getString("latitude");
                return Double.parseDouble(latitudeCity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
return 0;
    }

    public double getLongitude(String city) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select longitude from cities where name='" + city + "'");
            while (rs.next()) {
                String longitudeCity = rs.getString("longitude");
                return Double.parseDouble(longitudeCity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void getDistanceBetween2Cities(String city1, String city2) {
        double latitude1 = getLatitude(city1);
        double latitude2 = getLatitude(city2);
        double longitude1 = getLongitude(city1);
        double longitude2 = getLongitude(city2);
        System.out.println(distance(latitude1, latitude2, longitude1, longitude2) + " km");
    }


    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;
        return (dist);
    }

    /**
     * converts decimal degrees to radians
     *
     * @param deg
     * @return
     */

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /**
     * converts radians to decimal degrees
     *
     * @param rad
     * @return
     */

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
