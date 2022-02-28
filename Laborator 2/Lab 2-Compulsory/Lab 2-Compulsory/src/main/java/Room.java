
public class Room {
    //Atributele clasei Room
    private String name;
    private int capacity;
    private RoomType type; // type este de tip RoomType, deoarece am folosit enum
    //Constructorul pentru clasa Room
    public Room(String name, int capacity, RoomType type) {
        setName(name);
        setCapacity(capacity);
        setType(type);
    }
    //Metodele clasei Room sunt 3 functii setters si 3 functii getters si o functie de print
    // in plus suprascriem metoda toString
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
