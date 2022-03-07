/**
 * Clasa Switch
 * @author Petrea Daniela
 */

public class Switch extends Node{
    /**
     * constructorul clasei Switch
     * @param name
     */
    Switch(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "name='" + name + "'}";
    }

}