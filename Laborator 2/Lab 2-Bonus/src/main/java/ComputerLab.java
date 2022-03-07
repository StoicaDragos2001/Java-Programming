/**
 * Clasa ComputerLab
 *
 * @author Petrea Daniela
 */

/**
 * inlocuim enum prin construirea a 2 clase separate LectureHall si ComputerLab, iar clasa Room devine abstracta
 */

public final class ComputerLab extends Room {
    private String operatingSystem;

    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * @param name            numele camerei care este laborator
     * @param capacity        capacitatea camerei
     * @param operatingSystem sistemul de operare al calculatorului
     */

    public ComputerLab(String name, int capacity, String operatingSystem) {
        super(name, capacity);
        setName(name);
        setCapacity(capacity);
        setOperatingSystem(operatingSystem);
        System.out.printf("Created the %s computer lab!\n", this.name);
    }
}
