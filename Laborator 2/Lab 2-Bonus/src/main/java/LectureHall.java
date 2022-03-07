/**
 * Clasa LectureHall
 *
 * @author Petrea Daniela
 */

/**
 * inlocuim enum prin construirea a 2 clase separate LectureHall si ComputerLab, iar clasa Room devine abstracta
 */

public final class LectureHall extends Room {
    private boolean videoProjector;

    public boolean isVideoProjector() {
        return this.videoProjector;
    }

    public void setVideoProjector(boolean videoProjector) {
        this.videoProjector = videoProjector;
    }

    /**
     *
     * @param name numele camerei care este sala de lectura
     * @param capacity capacitatea camerei
     * @param videoProjector daca are sau nu sala de lectura video-proiector
     */
    public LectureHall(String name, int capacity, boolean videoProjector) {
        setName(name);
        setCapacity(capacity);
        setVideoProjector(videoProjector);
        System.out.printf("Created the %s lecture hall!\n", this.name);
    }
}
