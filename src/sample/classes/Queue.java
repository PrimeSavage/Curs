package sample.classes;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class Queue
 */
public class Queue {
    /**
     * Array list of Process
     */
    private ArrayList<Process> queue;
    /**
     * Object of reject queue
     */
    private RejectQueue rejectQueue;
    /**
     * Object of ready queue
     */
    private ReadyQueue readyQueue;
    /**
     * Object of finished queue
     */
    private FinishedQueue finishedQueue;
    /**
     * Last id of process
     */
    private int lastID;
    /**
     * Object of memory scheduler
     */
    private MemoryScheduler memoryScheduler;
    /**
     * check memory
     */
    private boolean checkMemory;
    /**
     * Average service wait
     */
    private int averageServiceWait = 0;

    /**
     * Constructor of Queue
     */
    public Queue() {
        queue = new ArrayList<>();
        rejectQueue = new RejectQueue();
        readyQueue = new ReadyQueue();
        finishedQueue = new FinishedQueue();
        lastID = 1;
        checkMemory = true;
        memoryScheduler = new MemoryScheduler();
    }

    private void add() {
        queue.add(new Process(lastID++));
    }

    public int getAverageServiceWait() { return averageServiceWait; }

    /**
     * Creat ready queue
     */
    public void createReadyQueue() {
        queue.sort(Comparator.comparingInt(Process::getTimeIn));
        for (int i = 0; i < queue.size(); i++) {
            averageServiceWait += ClockGenerator.getTime() - queue.get(0).getTimeIn();
            if (checkMemory) {
                checkMemory = memoryScheduler.add(queue.get(0).getMemory(), queue.get(0));
                queue.get(0).setState(State.Waiting);
                queue.get(0).setTimeInReadyQueue(ClockGenerator.getTime());
                readyQueue.addReadyQueue(queue.get(0));
            } else {
                if (memoryScheduler.findFreeBlock(queue.get(0).getMemory(), queue.get(0))) {
                    queue.get(0).setState(State.Waiting);
                    queue.get(0).setTimeInReadyQueue(ClockGenerator.getTime());
                    readyQueue.addReadyQueue(queue.get(0));
                } else {
                    rejectQueue.addRejectQueue(queue.get(0));
                }
            }
            queue.remove(0);
        }
    }

    /**
     * Add n processes
     *
     * @param N quantity of processes
     */
    public void add(final int N) {
        for (int i = 0; i < N; i++) {
            add();
        }
    }

    public int getLastID() {
        return lastID;
    }

    /**
     * Get memory scheduler
     *
     * @return memory scheduler
     */
    public MemoryScheduler getMemoryScheduler() {
        return memoryScheduler;
    }

    /**
     * Get ready queue
     *
     * @return ready queue
     */
    public ReadyQueue getReadyQueue() {
        return readyQueue;
    }

    /**
     * Get finished queue
     *
     * @return finished queue
     */
    public FinishedQueue getFinishedQueue() {
        return finishedQueue;
    }

    /**
     * Get reject queue
     *
     * @return reject queue
     */
    public RejectQueue getRejectQueue() {
        return rejectQueue;
    }

    /**
     * Get queue
     *
     * @return queue
     */
    public ArrayList<Process> getQueue() {
        return queue;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (final Process process : queue) {
            result.append(process).append("\n");
        }
        return result.toString();
    }
}
