package instances;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    private String id;
    private String title;
    private String location; //file name or Web page

    private Map<String, Object> tags = new HashMap<>();

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public Item(String id, String title, String location){
        this.id = id;
        this.title=title;
        this.location= this.location;
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

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
