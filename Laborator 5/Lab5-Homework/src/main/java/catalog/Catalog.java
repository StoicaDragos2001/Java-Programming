package catalog;
import com.fasterxml.jackson.annotation.JsonProperty;
import exception.CustomException;
import instances.Item;
import java.util.*;

public class Catalog {

    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog(@JsonProperty("myRefs") String name)  {
        this.name = name;

    }
    /**
     *
     * @param item that the item we want to add in the catalog
     * @throws CustomException if the id of the item is already in the list of items
     */
    public void add(Item item) throws CustomException {
        for(int index=0;index<items.size();index++){
            if(items.get(index).getId().equals(item.getId())){
                throw new CustomException(item.getId());
            }
        }
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

}
