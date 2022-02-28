public class Event {
    private String name;
    private int size;
    private int startTime;
    private int endTime;

    public Event(String name, int size, int start_time, int end_time) {
        setName(name);
        setSize(size);
        setStartTime(start_time);
        setEndTime(end_time);

    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int newSupply) {
        this.size = size;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return "Event{" + "name='" + name+'\'' + ", size="+ size+ ", start_time=" + startTime+ ", end_time=" + endTime+'}';
    }
}
