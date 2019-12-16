package sample.classes;

import java.util.ArrayList;

/**
 * Class FinishedQueue
 */
class FinishedQueue {
    /**
     * Array list of processes
     */
    private ArrayList<Process> finishedQueue;
    /**
     *  Quantity finished queue
     */
    private int quantityFinishedQueue;

    FinishedQueue() {
        finishedQueue = new ArrayList<>();
        quantityFinishedQueue = 1;
    }

    /**
     * Get finished queue
     * @return finished queue
     */
    public ArrayList<Process> getFinishedQueue() {
        return finishedQueue;
    }

    public int getQuantityFinishedQueue() {
        return quantityFinishedQueue;
    }

    /**
     * Add to array list process
     * @param process process
     */
    public void addFinishedQueue(final Process process) {
        finishedQueue.add(process);
        quantityFinishedQueue++;
    }
}
