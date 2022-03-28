package instances;

/**
 * class Book that extends class Item
 * @author Petrea Daniela
 */
public class Book extends Item{
 private String author;
 private int year;
 private String type;
    public Book(String id, String title, String location, int year, String author, String type) {
        this.author = author;
        this.year = year;
        this.id = id;
        this.title =title;
        this.location=location;
        this.type=type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" + getTitle()+
                ", year=" + year +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}