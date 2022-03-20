package Instances;

/**
 * class Intersection
 * @author Petrea Daniela
 */
public class Intersection {
    private String name;
    public Intersection(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * I do override toString s.t
     * @return intersection with the name
     */
    @Override
    public String toString() {
        return "Intersection " + getName();
    }
}