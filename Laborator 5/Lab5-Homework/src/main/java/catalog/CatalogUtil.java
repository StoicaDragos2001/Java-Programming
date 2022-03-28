package catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.CustomException;
import instances.Item;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class CatalogUtil {

    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }

    public static Catalog load(String path)
            throws CustomException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(new File(path));
        return objectMapper.readValue(new File(path), Catalog.class);
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
