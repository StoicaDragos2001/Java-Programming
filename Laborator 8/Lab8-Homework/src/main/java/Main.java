import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import connection.Database;
import daos.CityDao;
import daos.ContinentDao;
import daos.CountryDao;

import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static dataset.DataSetParser.putDataInDatabase;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException, IOException {
        // shell();
        bonus();
    }

    public static void bonus() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/xe");
        config.setUsername("STUDENT");
        config.setPassword("STUDENT");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(config);

    }

    public static void shell() throws SQLException, InterruptedException, IOException {
        Database.createConnection();
        Database.getConnection().commit();
        putDataInDatabase();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            shellCommands();
            String commandIndex = scanner.nextLine();
            var continents = new ContinentDao();
            var countries = new CountryDao();
            var cities = new CityDao();
            switch (commandIndex) {
                case "1": {
                    continents.findByName("Europe");
                    continue;
                }
                case "2": {
                    continents.findById(4);
                    continue;
                }
                case "3": {
                    continents.create("continentNou", 100);
                    continue;
                }
                case "4": {
                    countries.create("taraNoua", 100);
                    continue;
                }
                case "5": {
                    System.out.println("The countries from Europe are:");
                    countries.print(5);
                    continue;
                }
                case "6": {
                    System.out.println("The continents are:");
                    continents.print();
                    continue;
                }
                case "7": {
                    System.out.println("The cities are:");
                    cities.print();
                    continue;
                }
                case "8": {
                    System.out.print("The capital for United States is ");
                    cities.printCapital("United States");
                    System.out.println();
                    continue;
                }
                case "9": {
                    cities.create("orasNou", 1000, "taraNoua", 0, "12", "23");
                    continue;
                }
                case "10": {
                    System.out.print("Distance between Paris and Jerusalem in km is ");
                    cities.getDistanceBetween2Cities("Paris", "Jerusalem");
                    System.out.println();
                    continue;
                }
                case "11": {
                    System.out.println("Thank you! Have a nice day!");
                    Database.getConnection().close();
                    System.exit(1);
                }
                default: {
                    System.out.println("Wrong command index! Try again!");
                }

            }
        }
    }

    public static void shellCommands() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\n\nYou have the next commands:");
        System.out.println("1 - Find a continent by name");
        System.out.println("2 - Find a continent by ID");
        System.out.println("3 - Add a continent");
        System.out.println("4 - Add a country");
        System.out.println("5 - Print all the countries from a given continent");
        System.out.println("6 - Print all the continents");
        System.out.println("7 - Print all the cities");
        System.out.println("8 - Print the capital for a given country");
        System.out.println("9 - Add a city");
        System.out.println("10 - Print the distance between 2 cities");
        System.out.println("11 - Quit\n\n");
        System.out.print("Type your command index: ");
    }


}
