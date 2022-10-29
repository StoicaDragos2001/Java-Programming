import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * Utility Class for generating parameters.
 *
 * @author Stoica Dragos-Stefan 2A5
 */
public final class Generator {
    /**
     * Generates the number of instances.
     *
     * @return A random integer between 80 and 100.
     */
    public static int generateNumberOfInstances() {
        Random rand = new Random();
        int low = 80;
        int high = 100;
        return rand.nextInt(high - low) + low;
    }

    /**
     * Generates an event name.
     *
     * @return A string formed by a random letter concatenated with a random number between 1 and 1000.
     */
    public static String generateEventName() {
        Random rand1 = new Random();
        Random rand2 = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char letter = alphabet.charAt(rand1.nextInt(alphabet.length()));
        int low = 1;
        int high = 1000;
        int result = rand2.nextInt(high - low) + low;
        return letter + String.valueOf(result);
    }

    /**
     * Generates a room name.
     *
     * @return A string formed by a number between 100 and 99999.
     */
    public static String generateRoomName() {
        Random rand = new Random();
        int low = 100;
        int high = 99999;
        int result = rand.nextInt(high - low) + low;
        return String.valueOf(result);
    }

    /**
     * Flips a coin.
     *
     * @return True or false with an equal probability of 50%.
     */
    public static boolean coinFlip() {
        Random rand = new Random();
        int low = 0;
        int high = 2;
        int result = rand.nextInt(high - low) + low;
        if (result == 0)
            return true;
        else
            return false;
    }

    /**
     * Generates a room/event size.
     *
     * @return Returns a random integer from {30,50,100,150,300}.
     */
    public static int generateSize() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(50);
        list.add(100);
        list.add(150);
        list.add(300);
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    /**
     * Generates an hour.
     *
     * @return A random even LocalTime value between 08:00 and 18:00
     */
    public static LocalTime generateHour() {
        ArrayList<String> list = new ArrayList<>();
        list.add("08:00");
        list.add("10:00");
        list.add("12:00");
        list.add("14:00");
        list.add("16:00");
        list.add("18:00");
        Random rand = new Random();
        return LocalTime.parse(list.get(rand.nextInt(list.size())));
    }

    /**
     * Generates an operation system.
     *
     * @return Returns one of the following OS: Windows 10, Linux, Windows XP.
     */
    public static String generateOS() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Windows 10");
        list.add("Linux");
        list.add("Windows XP");
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
