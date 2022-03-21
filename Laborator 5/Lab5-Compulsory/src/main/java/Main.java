import catalog.Catalog;
import catalog.CatalogUtil;
import instances.Article;
import instances.Book;

public class Main {
    Catalog c = new Catalog("C:\\Users\\Daniela-211021\\IdeaProjects\\Lab5-Compulsory\\catalog.txt");
    Book item1 = new Book("knuth67", "Pride and prejudice", "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab5-Compulsory\\pride_and_prejudice.pdf", 1813, "Jane Austen", "book");
    Article item2 = new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others", "article");
    CatalogUtil catalog=new CatalogUtil();
    //catalog.add(c,item1);
    //catalog.add(c,item2);
}
