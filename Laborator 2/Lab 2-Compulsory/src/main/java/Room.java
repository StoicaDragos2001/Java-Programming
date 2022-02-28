
public class Room {

    private String name;
    private int capacity;
    private RoomType type;

    public Room(String name, int capacity, RoomType type) {
        setName(name);
        setCapacity(capacity);
        setType(type);
    }

    public String getName(){
        return name;
    }

    public RoomType getType(){
        return type;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void print() {
        System.out.println(toString());
    }
    @Override
    public String toString(){
        return "Room{" + "name='" + name+'\'' + ", type="+ type+ ", capacity=" + capacity+'}';
    }


}
