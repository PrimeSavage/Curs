package sample.classes;

import java.util.ArrayList;

/**
 * Class RejectQueue
 */
class RejectQueue {
    /**
     * Array list of Process
     */
    private ArrayList<Process> rejectQueue;
    /**
     * Quantity reject queue
     */
    private int  quantityRejectQueue;

    /**
     * Constructor of reject queue
     */
    RejectQueue() {
        rejectQueue = new ArrayList<>();
        quantityRejectQueue = 1;
    }

    /**
     * Add to reject queue
     * @param process process
     */
    public void addRejectQueue(final Process process) {
        rejectQueue.add(process);
        quantityRejectQueue++;
    }

    public int getQuantityRejectQueue() {
        return quantityRejectQueue;
    }

    /**
     * Get reject queue
     * @return reject queue
     */
    public ArrayList<Process> getRejectQueue() {
        return rejectQueue;
    }
}
