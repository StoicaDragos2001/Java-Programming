
/**
 * Clasa Computer
 * @author Petrea Daniela
 */
/**
 * nodul de tip Computer poate fi identificat prin adresa si are capacitatea de a stoca
 */
public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private long storageCapacity;

    public Computer(String name,String address,long storageCapacity) {
        super(name);
        setAddress(address);
        setStorageCapacity(storageCapacity);
        System.out.println("Storage Capacity in bytes "+returnStorageCapacityByte(storageCapacity));
        System.out.println("Storage Capacity in Kilobytes "+returnStorageCapacityKilobyte(storageCapacity));
        System.out.println("Storage Capacity in Megabytes "+returnStorageCapacityMegabyte(storageCapacity));
    }
    /**
     * suprascriem metoda getAddress din interfata Identifiable
     * @return adresa
     */
    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * suprascriem metoda getStorageCapacity din interfata Storage
     * @return storageCapacity
     */
    @Override
    public long getStorageCapacity() {
        return storageCapacity;
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