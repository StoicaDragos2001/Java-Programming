/**
 * class Main
 * @author Petrea Daniela
 */

import catalog.Catalog;
import catalog.CatalogUtil;
import exception.CustomException;
import instances.Article;
import instances.Book;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CustomException {
        Main app = new Main();
        app.testCreateSaveView();
        app.testLoad();

    }

    /**
     * I call the methods add, save and view
     * @throws IOException
     */
    private void testCreateSaveView() throws IOException, CustomException {
        Catalog catalog = new Catalog("myRefs");
        Book item1 = new Book("pride13", "Pride and prejudice", "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab5-Compulsory\\pride_and_prejudice.pdf", 1813, "Jane Austen", "book");
        Article item2 = new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others", "article");
        catalog.add(item1);
        catalog.add(item2);
        CatalogUtil.save(catalog, "C:\\Users\\Daniela-211021\\IdeaProjects\\research\\catalog.json");
        CatalogUtil.view(catalog.getCatalog().get(0));
    }

    /**
     * I call the method load
     * @throws IOException
     */
    private void testLoad() throws IOException {
        Catalog catalog1 = CatalogUtil.load("C:\\Users\\Daniela-211021\\IdeaProjects\\research\\catalog.json");
        System.out.println(catalog1);
    }
}