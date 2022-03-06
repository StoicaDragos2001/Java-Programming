/**
 * Clasa Main
 *
 * @author Petrea Daniela
 */
import java.time.LocalTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RandomGenerator randomizer = new RandomGenerator();
        int numberOfEvents=randomizer.generateNumberOfInstances();
        Event[] events = new Event[numberOfEvents];
        for (int instanceEvent = 0; instanceEvent < numberOfEvents; instanceEvent++) {
            LocalTime hour = randomizer.generateHour();
            Random random = new Random();
            events[instanceEvent]=new Event(randomizer.generateEventName(), randomizer.generateSizeAndCapacity(), hour, hour.plusHours(2));
        }
        int numberOfRooms=randomizer.generateNumberOfInstances();
        Room[] rooms = new Room[numberOfRooms];
        for (int instanceRoom = 0; instanceRoom < numberOfRooms; instanceRoom++) {
            if (randomizer.generateTrueOrFalse())
                rooms[instanceRoom]=new ComputerLab(randomizer.generateRoomName(), randomizer.generateSizeAndCapacity(), randomizer.generateOperatingSystem());
            else
                rooms[instanceRoom]=new LectureHall(randomizer.generateRoomName(), randomizer.generateSizeAndCapacity(), randomizer.generateTrueOrFalse());
        }
        Problem problem = new Problem(events, rooms);
        Room[] rooms1 = problem.getRooms();
        Event[] events1 = problem.getEvents();
        for(Room r : rooms1){
            r.print();
        }
        for(Event e : events1){
            e.print();
        }
        Solution solution = new Solution();
        solution.toResolve(events1,rooms1);
        System.out.println("-----------------------------------------------------------");
        DSaturAlgorithm dSaturSolution = new DSaturAlgorithm();
        dSaturSolution.toResolve(events1,rooms1);
    }

}