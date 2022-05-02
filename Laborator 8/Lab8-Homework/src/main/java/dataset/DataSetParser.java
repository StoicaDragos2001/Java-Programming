package dataset;

import com.opencsv.CSVReader;
import daos.*;
import instances.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSetParser {

    private final static String DATASET_PATH = "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab8-Homework\\concap.csv";

    public static void putDataInDatabase() throws IOException, SQLException {
        CSVReader csvReader = new CSVReader(new FileReader(DATASET_PATH));
        csvReader.readNext(); // skip the name column row
        String[] row;
        int i = 0;
        ArrayList <String> nameContinents = new ArrayList<>();
        while ((row = csvReader.readNext()) != null) {
            i++;
            var continents = new ContinentDao();
            if(nameContinents.contains(row[5])==false)
            continents.create(row[5],i);
            nameContinents.add(row[5]);
            var countries = new CountryDao();
            int continentId = continents.findByName(row[5]);
            countries.create(row[1],continentId);
            var cities=new CityDao();
            cities.create(row[1],i,row[0],1,row[2],row[3]);
        }
    }
}

