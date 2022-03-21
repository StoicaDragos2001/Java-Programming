package instances;


public class Article extends Item {
    private int year;
    private String author;
    private String type;

    public Article(String id, String title, String location, int year, String author, String type) {
        super(id, title, location);
        this.year=year;
        this.author=author;
        this.type=type;
    }

    @Override
    public String toString() {
        return "Article{" + getTitle()+
                ", year=" + year +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}