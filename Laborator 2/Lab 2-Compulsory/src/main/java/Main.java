
public class Main {
    public static void main(String[] args) {
        Event C1 = new Event("C1", 100, 8, 10);
        Event C2 = new Event("C1", 100, 8, 10);
        Event C3 = new Event("C1", 100, 8, 10);
        C1.print();
        C2.print();
        C3.print();
        Room R401 = new Room("401", 30,RoomType.computerLabs);
        Room R403 = new Room("403", 30,RoomType.computerLabs);
        Room R405 = new Room("405", 30,RoomType.computerLabs);
        Room R309 = new Room("309", 100,RoomType.lectureHalls);
        R401.print();
        R403.print();
        R405.print();
        R309.print();
    }
}