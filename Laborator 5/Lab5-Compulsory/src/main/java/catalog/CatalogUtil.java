package catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import instances.Item;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save (Catalog catalog, String locatie) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(locatie), catalog);
    }

    public static Catalog load(String locatie) throws IOException {
        Catalog catalog = new Catalog("myRefs");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            catalog = objectMapper.readValue(new File(locatie), Catalog.class);
        } catch (FileNotFoundException e) {
            System.err.println("The file at the location " + locatie + " is missing!");
        }
        return catalog;
    }
    public static void view(Item item) throws IOException {
        if (item.getLocation().contains("www")) {
            URI u = null;
            try {
                u = new URI(item.getLocation());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            Desktop d = Desktop.getDesktop();
            d.browse(u);
        } else {
            File u = new File(item.getLocation());
            Desktop d = Desktop.getDesktop();
            d.open(u);
        }
    }
}