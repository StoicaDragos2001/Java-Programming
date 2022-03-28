package instances;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.*;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "name")
@JsonSubTypes({ @JsonSubTypes.Type(value = Book.class, name = "book"), @JsonSubTypes.Type(value = Article.class, name = "article") })
public abstract class Item implements Serializable {
    protected String id;
    protected String title;
    protected String location;

    public Item(String id, String title, String location) {

        this.id = id;
        this.location = location;
        this.title = title;

    }
    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
