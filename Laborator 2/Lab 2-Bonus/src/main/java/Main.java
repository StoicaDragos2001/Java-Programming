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
        int numberOfEvents = randomizer.generateNumberOfInstances();
        Event[] events = new Event[numberOfEvents];
        for (int instanceEvent = 0; instanceEvent < numberOfEvents; instanceEvent++) {
            LocalTime hour = randomizer.generateHour();
            events[instanceEvent] = new Event(randomizer.generateEventName(), randomizer.generateSizeAndCapacity(), hour, hour.plusHours(2));
        }
        int numberOfRooms = randomizer.generateNumberOfInstances();
        Room[] rooms = new Room[numberOfRooms];
        for (int instanceRoom = 0; instanceRoom < numberOfRooms; instanceRoom++) {
            if (randomizer.generateTrueOrFalse())
                rooms[instanceRoom] = new ComputerLab(randomizer.generateRoomName(), randomizer.generateSizeAndCapacity(), randomizer.generateOperatingSystem());
            else
                rooms[instanceRoom] = new LectureHall(randomizer.generateRoomName(), randomizer.generateSizeAndCapacity(), randomizer.generateTrueOrFalse());
        }
        Problem problem = new Problem(events, rooms);
        Room[] rooms1 = problem.getRooms();
        Event[] events1 = problem.getEvents();
        for (Room r : rooms1) {
            r.print();
        }
        for (Event e : events1) {
            e.print();
        }
        Solution solution = new Solution();
        long start = System.nanoTime();
        solution.toResolve(events1, rooms1);
        long end = System.nanoTime();
        long execution = end - start;
        System.out.println("Timpul de executie pt algoritmul Greedy este de: " + execution + " nanosecunde");
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memoria folosita in biti: " + memory);
        System.out.println("-----------------------------------------------------------");
        DSaturAlgorithm dSaturSolution = new DSaturAlgorithm();
        long start1 = System.nanoTime();
        dSaturSolution.toResolve(events1, rooms1);
        long end1 = System.nanoTime();
        long execution1 = end1 - start1;
        System.out.println("Timpul de executie pentru algoritmul lui DSatur este de: " + execution1 + " nanosecunde");
        Runtime runtime1 = Runtime.getRuntime();
        runtime1.gc();
        long memory1 = runtime1.totalMemory() - runtime1.freeMemory();
        System.out.println("Memoria folosita in biti: " + memory1);
    }

}