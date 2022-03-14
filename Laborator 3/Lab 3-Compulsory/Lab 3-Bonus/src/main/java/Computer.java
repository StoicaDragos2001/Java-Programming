
/**
 * Clasa Computer
 * @author Petrea Daniela
 */

/**
 * nodul de tip Computer poate fi identificat prin adresa si are capacitatea de a stoca
 */
public class Computer extends Node implements Identifiable, Storage {
    /**
     * atributele clasei Computer
     */
    private String address;
    private long storageCapacity;

    /**
     * Constructorul clasei Computer
     * @param name numele nodului de tip Computer
     * @param address numele adresei nodului de tip Computer
     * @param storageCapacity capacitatea nodului de tip Computer
     */

    public Computer(String name,String address,long storageCapacity) {
        super(name);
        setAddress(address);
        setStorageCapacity(storageCapacity);
        //System.out.println("Storage Capacity in bytes "+returnStorageCapacityByte(storageCapacity));
        //System.out.println("Storage Capacity in Kilobytes "+returnStorageCapacityKilobyte(storageCapacity));
       // System.out.println("Storage Capacity in Megabytes "+returnStorageCapacityMegabyte(storageCapacity));
    }

    /**
     * 2 functii getter
     * ele sunt suprascrise deoarece se regasesc si in interfele Storage si Identifiable
     */

    /**
     * suprascriem metoda getAddress din interfata Identifiable
     * @return adresa
     */
    @Override
    public String getAddress() {
        return address;
    }
    /**
     * suprascriem metoda getStorageCapacity din interfata Storage
     * @return storageCapacity
     */
    @Override
    public long getStorageCapacity() {
        return storageCapacity;
    }

    /**
     * 2 functii setter pt a seta adresa si capacitatea exprimata in GB
     */
    public void setAddress(String address) {
        this.address = address;
    }


    public void setStorageCapacity(long storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name=" + getName() + " address="+ getAddress()+ " storage= "+ getStorageCapacity() + " }";
    }

}