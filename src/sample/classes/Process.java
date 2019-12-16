package sample.classes;

/**
 * Class Process
 */
public class Process {
    /**
     * Id of process
     */
    private int id;
    /**
     * Name of process
     */
    private String name;
    /**
     * Priority of process
     */
    private int priority;
    /**
     * Time of process
     */
    private int time;
    /**
     * Memory of process
     */
    private int memory;
    /**
     * Time in of process
     */
    private int timeIn;
    /**
     * ime in ready queue of process
     */
    private int timeInReadyQueue;
    /**
     * Burst time of process
     */
    private int burstTime;
    /**
     * State of process
     */
    private State state;
    /**
     * Memory block of process
     */
    private MemoryBlock memoryBlock;

    public int getTimeInReadyQueue() {
        return timeInReadyQueue;
    }

    public void setTimeInReadyQueue(final int timeInReadyQueue) {
        this.timeInReadyQueue = timeInReadyQueue;
    }

    public void setPriority(final int priority) {
        this.priority = priority;
    }

    public void setBurstTime(final int burstTime) {
        this.burstTime = burstTime;
    }

    public void setTimeIn(final int timeIn) {
        this.timeIn = timeIn;
    }

    public void setState(final State state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() { return priority; }

    public int getTime() {
        return time;
    }

    public int getMemory() {
        return memory;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public State getState() {
        return state;
    }

    public MemoryBlock getMemoryBlock() {
        return memoryBlock;
    }

    public void setMemoryBlock(final MemoryBlock memoryBlock) {
        this.memoryBlock = memoryBlock;
    }

    Process(final int id) {
        this.id = id;
        this.memory = Utils.getRandomInteger(10, Configuration.memoryVolume / 2);
        this.priority = Utils.getRandomInteger(1, Configuration.maxPriority);
        this.time = Utils.getRandomInteger(1, 2000);
        this.timeIn = ClockGenerator.getTime();
        this.timeInReadyQueue = 0;
        this.burstTime = 0;
        this.name = "P" + this.id;
        this.state = State.Ready;
    }

    @Override
    public String toString() {
        return id +
                "{ name='" + name + '\'' +
                ", priority=" + priority +
                ", time=" + time +
                ", memory=" + memory +
                ", timeIn=" + timeIn +
                ", burstTime=" + burstTime +
                ", state=" + state +
                ", MemoryBlock=" + memoryBlock +
                '}';
    }
}


