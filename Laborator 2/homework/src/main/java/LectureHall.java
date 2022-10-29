/**
 * This class is for manipulating and creating LectureHall subclass.
 *
 * @author Stoica Dragos-Stefan 2A5
 */
public class LectureHall extends Room {
    protected boolean hasVideoProjector;

    /**
     * Constructor for subclass LectureHall.
     *
     * @param name              Name of used lecture hall.
     * @param capacity          Capacity of used lecture hall.
     * @param hasVideoProjector Whether lecture hall has a video projector or not.
     */
    LectureHall(String name, int capacity, boolean hasVideoProjector) {
        super(name, capacity);
        this.hasVideoProjector = hasVideoProjector;
    }

    /**
     * This method is a setter for hasVideoProjector.
     *
     * @param hasVideoProjector Whether lecture hall has a video projector or not.
     */
    public void setHasVideoProjector(boolean hasVideoProjector) {
        this.hasVideoProjector = hasVideoProjector;
    }

    /**
     * This method is a getter for hasVideoProjector.
     *
     * @return hasVideoProjector attribute.
     */
    public boolean getHasVideoProjector() {
        return hasVideoProjector;
    }

    /**
     * Overwritten toString method for LectureHall subclass.
     *
     * @return Formatted String of LectureHall attributes.
     */
    @Override
    public String toString() {
        return "Room{" +
                "name='" + getName() + '\'' +
                ", capacity=" + getCapacity() +
                ", has video projector=" + getHasVideoProjector() +
                '}';
    }
}
