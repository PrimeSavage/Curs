package sample.classes;


import java.util.ArrayList;

/**
 * Class ReadyQueue
 */
public class ReadyQueue {
    /**
     * Array list of Process
     */
    private ArrayList<Process> readyQueue;
    /**
     * Quantity ready queue
     */
    private int quantityReadyQueue;

    public int getQuantityReadyQueue() {
        return quantityReadyQueue;
    }

    /**
     * Constructor of ready queue
     */
    ReadyQueue() {
        readyQueue = new ArrayList<>();
        quantityReadyQueue = 0;
    }

    /**
     * Get ready queue
     * @return ready queue
     */
    public ArrayList<Process> getReadyQueue() {
        return readyQueue;
    }

    /**
     * Add to ready queue
     * @param process process
     */
    public void addReadyQueue(final Process process) {
        readyQueue.add(process);
        quantityReadyQueue++;
    }

    @Override
    public String toString() {
        return "ReadyQueue{" +
                "readyQueue=" + readyQueue +
                '}';
    }
}
