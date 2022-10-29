public class Room {
    //Stoica Dragos-Stefan 2A5
    private String name;
    private RoomType type;
    private int capacity;

    //constructor
    Room(String name, RoomType type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //getters
    public String getName() {
        return name;
    }

    public RoomType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    //suprascrierea lui toString pt a afisa toate atributele clasei Room
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                '}';
    }
}
