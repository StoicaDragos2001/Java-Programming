package Randomizer;

/**
 * Class RandomInstances
 * @author Petrea Daniela
 */

import java.util.Random;

/**
 * class for generate random instances
 */
public class RandomInstances {
    /**
     *
     * @return a number beetween 3 and 10 that represents number of intersections
     */

    public int generateNumberOfIntersections() {
        Random random = new Random();
        return random.nextInt(3,11);
    }

    /**
     *
     * @param numberOfIntersections that represents random number of intersections
     * @return a number between number of intersections+1 and number of intersections+10
     */
    public int generateNumberOfStreets(int numberOfIntersections) {
        Random random = new Random();
        return random.nextInt(numberOfIntersections+1,numberOfIntersections+11);
    }

    /**
     *
     * @return a number between 5 and 50 that represents the length of a street
     */
    public int generateLength(){
        Random random = new Random();
        return random.nextInt(5,51);
    }

    /**
     *
     * @param mistery that represents the number of intersection
     * @return a number smaller than the total number of intersections
     */
    public int generateWhichNode(int mistery){
        Random random = new Random();
        return random.nextInt(mistery-1);
    }

    /**
     *
     * @param mistery1 that represents the first intersection
     * @param mistery2 that represents the total number of intersections
     * @return a number between mistery+1 and mistery2
     */
    public int generateWhichNodeDestination(int mistery1,int mistery2){
        Random random = new Random();
        return random.nextInt(mistery1+1,mistery2);
    }

}
