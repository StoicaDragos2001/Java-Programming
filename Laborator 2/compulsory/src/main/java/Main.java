public class Main {
    //Stoica Dragos-Stefan 2A5
    public static void main(String[] args){
        Event E1 = new Event("C1", 100, 8, 10);
        Event E2 = new Event("C2", 100, 10, 12);
        Event E3 = new Event("L1", 30, 8, 10);
        Event E4 = new Event("L2", 30, 8, 10);
        Event E5 = new Event("L3", 30, 10, 12);


        Room R1 = new Room("401", RoomType.LAB, 30);
        Room R2 = new Room("403", RoomType.LAB, 30);
        Room R3 = new Room("405", RoomType.LAB, 30);
        Room R4 = new Room("309", RoomType.LECTUREHALL, 100);

        System.out.println(E1.toString());
        System.out.println(E2.toString());
        System.out.println(E3.toString());
        System.out.println(E4.toString());
        System.out.println(E5.toString());

        System.out.println(R1.toString());
        System.out.println(R2.toString());
        System.out.println(R3.toString());
        System.out.println(R4.toString());

    }
}
