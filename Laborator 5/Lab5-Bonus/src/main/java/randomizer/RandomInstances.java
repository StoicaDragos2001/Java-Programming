package randomizer;
import java.util.Random;
public class RandomInstances {
    /**
     *
     * @return a number between 2 and 10 that represents the number of items
     */
    public int generateNumberOfItems() {
        Random random = new Random();
        return random.nextInt(2,11);
    }

    /**
     *
     * @return 0 or 1
     */
    public int whichItem(){
        Random random = new Random();
        return random.nextInt(2);
    }

    /**
     *
     * @return a random year between 1700 and 2021
     */
    public int randomYear(){
        Random random = new Random();
        return random.nextInt(1700,2022);
    }

    /**
     *
     * @return a number between 0 and 3
     */
    public int whichItem1(){
        Random random = new Random();
        return random.nextInt(4);
    }

    /**
     *
     * @return a number between 0 and 4
     */
    public int whichItem2(){
        Random random = new Random();
        return random.nextInt(5);
    }

    /**
     *
     * @return a number between 0 and 2
     */
    public int whichItem3(){
        Random random = new Random();
        return random.nextInt(3);
    }

}
