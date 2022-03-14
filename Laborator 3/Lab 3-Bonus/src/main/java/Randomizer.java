/**
 * Clasa Randomizer
 * @author Petrea Daniela
 */

import java.util.Random;

/**
 * clasa construita pt a genera instante random
 */
public class Randomizer {
    /**
     *
     * @return un numar de la 0 la 2 pt a sti daca nodul este Computer, Router sau Switch
     */
    public int generateWhichInstance() {
        Random random = new Random();
        return random.nextInt(2);
    }

    /**
     *
     * @return un numar de la 6 la 19, care reprezinta nr de instante
     */
    public int generateNumberOfInstances() {
        Random random = new Random();
        return random.nextInt(6,20);
    }

    /**
     *
     * @return un numar de la 100 la 400, care reprezinta capacitatea de stocare retinuta in GB
     */
    public int generateStorageCapacity() {
        Random random = new Random();
        return random.nextInt(100, 401);
    }

    /**
     *
     * @return un string ce reprezinta numele nodului
     */

    public String generateNodeName() {
        Random random1 = new Random();
        char c = (char) (random1.nextInt(26) + 'a');
        Random random2 = new Random();
        return c + String.valueOf(random2.nextInt(100));
    }

    /**
     *
     * @return un string ce reprezinta adresa ip
     */
    public String generateIpAdress() {
        Random random1 = new Random();
        return random1.nextInt(1000) +"."+ random1.nextInt(1000) +"."+ random1.nextInt(1000) +"."+ random1.nextInt(1000);
    }

    /**
     *
     * @param mistery se inlocuieste cu nr de noduri generate
     * @return indexul nodului de la care exista drum spre alt drum ( acesta trebuie sa fie mai mic ca nr de nodurile generate in total)
     */
    public int generateWhichNode(int mistery){
        Random random = new Random();
        return random.nextInt(mistery-5);
    }
    /**
     *
     * @param mistery1 se inlocuieste cu indexul nodului sursa
     * @param mistery2 se inlocuieste cu nr de noduri generate
     * @return indexul nodului spre care exista drum ( acesta trebuie sa fie mai mare ca indexul nodului sursa si mai mic ca nr de nodurile generate in total)
     */
    public int generateWhichNodeDestination(int mistery1,int mistery2){
        Random random = new Random();
        return random.nextInt(mistery1,mistery2);
    }

    /**
     *
     * @return un numar de la 1 la 50, care reprezinta costul drumului
     */
    public int generateCost(){
        Random random = new Random();
        return random.nextInt(1,51);
    }

    /**
     *
     * @return un nr de tip double de la 0 la 1 care reprezinta rata de esec
     */
    public double generateFailure(){
        Random random = new Random();
        return random.nextDouble(0.0,1.0);
    }
}
