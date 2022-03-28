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
    /**
     * we serialize the catalog in a json file from the specified path
     * @param catalog
     * @param path
     * @throws IOException
     */
    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }
    /**
     *
     * @param path
     * @return the catalog that we deserialize from jason file
     * @throws IOException
     */
    public static Catalog load(String path)
            throws CustomException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(new File(path));
        return objectMapper.readValue(new File(path), Catalog.class);
    }
    /**
     * method that we use to open the item( that can be of 2 types - a file in the computer or an url link)
     * @param item
     * @throws IOException
     */
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
