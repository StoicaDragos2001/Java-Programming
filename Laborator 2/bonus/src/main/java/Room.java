/**
 * This class is for manipulating and creating Room superclass
 *
 * @author Stoica Dragos-Stefan 2A5
 */
public abstract class Room {

    private String name;
    private int capacity;

    /**
     * Constructor for Room superclass.
     *
     * @param name     Name of used room.
     * @param capacity Capacity of used room.
     */
    Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * This method is a setter for name of used room.
     *
     * @param name Name of used room.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is a setter for capacity of used room.
     *
     * @param capacity Capacity of used room.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * This method is a getter for name attribute.
     *
     * @return Name of used room.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is a getter for capacity attribute.
     *
     * @return Capacity of used room.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Overwritten toString method for Room superclass.
     *
     * @return Formatted String of Room attributes.
     */
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    /**
     * Overwritten equals method for Room superclass.
     *
     * @param obj Instance of Object class.
     * @return Whether 2 objects are equal or not based on name.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Room))
            return false;
        Room other = (Room) obj;
        return name.equals(other.name);
    }
}
