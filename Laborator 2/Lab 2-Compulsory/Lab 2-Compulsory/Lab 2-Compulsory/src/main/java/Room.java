/**
* Clasa Room
*
* @author Petrea Daniela
 */

public class Room {

    /**
     * Atributele clasei Room sunt
     * name
     * capacity
     * type (care este de tip RoomType, deoarece am folosit enum)
     */

    private String name;
    private int capacity;
    private RoomType type;

    /**
     * Constructorul clasei Room
     * @param name numele camerei
     * @param capacity capacitatea camerei
     * @param type tipul camerei
     */

    public Room(String name, int capacity, RoomType type) {
        setName(name);
        setCapacity(capacity);
        setType(type);
    }

    /**
     * 3 functii setters
     */

    /**
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param type tipul camerei
     */

    public void setType(RoomType type) {
        this.type = type;
    }

    /**
     *
     * @param capacity capacitatea camerei
     */

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 3 functii getters
     */

    /**
     *
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return type
     */

    public RoomType getType(){
        return type;
    }

    /**
     *
     * @return capacity
     */

    public int getCapacity(){
        return capacity;
    }

    /**
     * o functie de print
     */

    /**
     * metoda pt a afisa numele, capacitatea si tipul unei camere
     */

    public void print() {
        System.out.println(toString());
    }

    /**
     *
     * facem @Override toString
     * deoarece suprascriem metoda toString
     */

    @Override
    public String toString(){
        return "Room{" + "name='" + name+'\'' + ", type="+ type+ ", capacity=" + capacity+'}';
    }

}
