package catalog;

import instances.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String location;
    private List<Item> items = new ArrayList<>();
    public Catalog(String name)  {
        this.location = location;
        items = new ArrayList<>();
    }
    public String getLocation() {
        return location;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void add(Item item) {
        items.add(item);
    }
    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
}