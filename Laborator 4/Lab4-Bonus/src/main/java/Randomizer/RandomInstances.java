package Randomizer;

/**
 * Clasa RandomInstances
 * @author Petrea Daniela
 */

import java.util.Random;

/**
 * clasa construita pt a genera instante random
 */
public class RandomInstances {


    public int generateNumberOfIntersections() {
        Random random = new Random();
        return random.nextInt(3,11);
    }

    public int generateNumberOfStreets(int numberOfIntersections) {
        Random random = new Random();
        return random.nextInt(numberOfIntersections+1,numberOfIntersections+10);
    }

    public int generateLength(){
        Random random = new Random();
        return random.nextInt(5,51);
    }

    public int generateWhichNode(int mistery){
        Random random = new Random();
        return random.nextInt(mistery-1);
    }

    public int generateWhichNodeDestination(int mistery1,int mistery2){
        Random random = new Random();
        return random.nextInt(mistery1+1,mistery2);
    }

}
