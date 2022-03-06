import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * generam valori random pt cele 2 instante de evenimente si camere
 */
public class RandomGenerator {
    /**
     *
     * @return un numar random intre 50 si 70, care reprezinta numarul de instante pentru array-ul de tip Room si cel de tip Event
     */
    public int generateNumberOfInstances() {
        Random random = new Random();
        return random.nextInt(50,71) ;
    }

    /**
     *
     * @return numele unui eveniment, care este alcatuit dintr-o litera mare, urmata de un numar de la 0 la 1000
     */

    public String generateEventName() {
        Random random1 = new Random();
        char c = (char)(random1.nextInt(26) + 'A');
        Random random2 = new Random();
        return c + String.valueOf(random2.nextInt(1001));
    }

    /**
     *
     * @return numele unei camere, care este un numar de la 1 la 10000
     */
    public String generateRoomName() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1,10001));
    }

    /**
     *
     * @return o valoare booleana, anume true sau false cu probabilitatea de 50%
     */
    public boolean generateTrueOrFalse() {
        Random random = new Random();
        if (random.nextInt(2)== 0)
            return true;
        else
            return false;
    }

    /**
     *
     * @return o valoare random pt size/capacitate din cele introduse de mine in lista (10,30,50,70,100,120,150)
     */
    public int generateSizeAndCapacity() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(30);
        list.add(50);
        list.add(70);
        list.add(100);
        list.add(120);
        list.add(150);
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    /**
     *
     * @return o ora random, pe care o vom folosi pt ora de incepere a evenimentului
     */

    public LocalTime generateHour() {
        Random random = new Random();
        LocalTime hour = LocalTime.parse("08:00");
        return hour.plusHours(random.nextInt(6)*2);
    }

    /**
     *
     * @return unul din sistemele de operare introduse de mine in lista de string-uri
     */
    public String generateOperatingSystem() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Windows 10");
        list.add("Windows 7");
        list.add("Linux Mint");
        list.add("Ubuntu");
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}