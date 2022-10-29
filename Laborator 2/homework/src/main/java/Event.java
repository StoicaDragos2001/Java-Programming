/**
 * This class is for manipulating and creating Event class
 *
 * @author Stoica Dragos-Stefan 2A5
 */
public class Event {
    private String name;
    private int size;
    private int startTime;
    private int endTime;

    /**
     * Constructor for Event class.
     *
     * @param name      Name of event.
     * @param size      Size of event.
     * @param startTime Beginning time of event.
     * @param endTime   Ending time of event.
     */
    Event(String name, int size, int startTime, int endTime) {
        this.size = size;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * This method is a setter for ending time of event.
     *
     * @param endTime Ending time of event.
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    /**
     * This method is a setter for name of event.
     *
     * @param name Name of event.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method is a setter for size of event.
     *
     * @param size Size of event.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * This method is a setter for beginning time of event.
     *
     * @param startTime Beginning time of event.
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * This method is a getter for ending time of event.
     *
     * @return endTime attribute.
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * This method is a getter for size of event.
     *
     * @return size attribute.
     */
    public int getSize() {
        return size;
    }

    /**
     * This method is a getter for beginning time of event.
     *
     * @return startTime attribute.
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * This method is a getter for name of event.
     *
     * @return name attribute.
     */
    public String getName() {
        return name;
    }


    /**
     * Overwritten toString method for Event class.
     *
     * @return Formatted String of Event attributes
     */
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    /**
     * Overwritten equals method for Event class.
     *
     * @param obj Instance of Object class.
     * @return Whether 2 objects are equal or not based on name.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Event))
            return false;
        Event other = (Event) obj;
        return name.equals(other.name);
    }
}
