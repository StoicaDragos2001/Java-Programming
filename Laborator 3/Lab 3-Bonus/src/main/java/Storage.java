public interface Storage {
    /**
     * in interfata Storage declar metoda getSorageCapacity pe care o suprascriu in clasa Computer
     */
    long getStorageCapacity();
    /*
    default long returnStorageCapacityMegabyte(long storageCapacity) {
        return storageCapacity * 1000;
    }
    default long returnStorageCapacityKilobyte(long storageCapacity) {
        return storageCapacity * 1000000;
    }
    default long returnStorageCapacityByte(long storageCapacity) {
        return storageCapacity * 1000000000;
    }
    */
}