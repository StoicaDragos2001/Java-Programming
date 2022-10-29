/**
 * This class is for manipulating and creating ComputerLab subclass.
 *
 * @author Stoica Dragos-Stefan 2A5
 */
public class ComputerLab extends Room {
    private String operatingSystem;

    /**
     * Constructor for subclass ComputerLab.
     *
     * @param name            Name of used computer laboratory.
     * @param capacity        Capacity of used computer laboratory.
     * @param operatingSystem Operating system of computer laboratory computers.
     */
    ComputerLab(String name, int capacity, String operatingSystem) {
        super(name, capacity);
        this.operatingSystem = operatingSystem;
    }

    /**
     * This method is a getter for operating system.
     *
     * @return operatingSystem attribute
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * This method is a setter for operating system.
     *
     * @param operatingSystem Operating system of computer laboratory computers.
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * Overwritten toString method for ComputerLab subclass.
     *
     * @return Formatted String of ComputerLab attributes.
     */
    @Override
    public String toString() {
        return "Room{" +
                "name='" + getName() + '\'' +
                ", capacity=" + getCapacity() +
                ", operating system=" + getOperatingSystem() +
                '}';
    }

}
