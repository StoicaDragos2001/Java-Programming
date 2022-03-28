package instances;

public class Article extends Item {
    private String author;
    private int year;
    private String type;


    public Article(String id, String title, String location, int year, String author, String type) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.author = author;
        this.year = year;
        this.type=type;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(int year) {
        this.year = year;
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