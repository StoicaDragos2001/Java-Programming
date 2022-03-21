package instances;

public class Book extends Item{
    private int year;
    private String author;
    private String type;

    public Book(String id, String title, String location, int year, String author, String type) {
        super(id, title, location);
        this.year=year;
        this.author=author;
        this.type=type;
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