package instances;

import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.CustomException;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("book")
public class Book extends Item {
    private int year;
    private String author;
    private String type;
    public Book(String id, String title, String location, int year, String author, String type) throws CustomException {
        super(id, title, location);
        this.year = year;
        this.author = author;
        this.type = type;
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
        return "Book{" + getTitle() +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}