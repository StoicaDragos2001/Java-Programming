package catalog;

import instances.Item;

import java.io.*;

public class CatalogUtil {

    public static void add(Catalog catalog, Item item) {
            catalog.add(item);
    }

    public static void save(Catalog catalog) throws IOException {
            FileOutputStream fos = new FileOutputStream(catalog.getLocation());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(catalog);
            oos.flush();
            fos.close();

    }

    public static Catalog load(String location) throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(location);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Catalog temp = (Catalog) ois.readObject();
            fis.close();
            return temp;
        }

}
