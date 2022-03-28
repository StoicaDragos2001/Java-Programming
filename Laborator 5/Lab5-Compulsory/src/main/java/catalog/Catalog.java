package catalog;
import com.fasterxml.jackson.annotation.JsonProperty;
import exception.CustomException;
import instances.Item;

import java.util.ArrayList;
import java.util.List;

public class Catalog{
    private List<Item> items = new ArrayList<>();
    private String name;
    public Catalog(@JsonProperty("myRefs") String name)  {
        this.name = name;

    }

    public void add(Item item){
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

    public List<Item> getCatalog() {
        return items;
    }

    public void setCatalog(List catalog) {
        this.items = catalog;
    }


    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}