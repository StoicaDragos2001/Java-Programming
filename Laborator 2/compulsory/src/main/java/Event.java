public class Event {
    //Stoica Dragos-Stefan 2A5
    private String name;
    private int size;
    private int startTime;
    private int endTime;

    //constructor
    Event(String name, int size, int startTime, int endTime){
        this.size = size;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //setters
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    //getters
    public int getEndTime() {
        return endTime;
    }

    public int getSize() {
        return size;
    }

    public int getStartTime() {
        return startTime;
    }

    public String getName() {
        return name;
    }

    //suprascrierea lui toString pt a afisa toate atributele clasei Event
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
