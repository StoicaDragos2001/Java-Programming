package instances;
import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.CustomException;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("article")
public class Article extends Item {
    private int year;
    private String author;
    private String type;
    public Article(String id, String title, String location, int year, String author, String type) throws CustomException {
        super(id, title, location);
        this.year=year;
        this.author=author;
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