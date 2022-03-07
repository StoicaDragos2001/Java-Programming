/**
 * Clasa Computer
 * @author Petrea Daniela
 */

public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private int storageCapacity;

    Computer(String name) {
        super(name);
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name +
                "'}";
    }

}