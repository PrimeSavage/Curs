package sample.classes;

import java.util.ArrayList;

/**
 * Class CreatRunningProcesses
 */
class CreatRunningProcesses {
    /**
     * Array list of RunningProcess
     */
    private ArrayList<RunningProcess> createRunningProcesses;
    /**
     * Array list of Boolean
     */
    private ArrayList<Boolean> runningProcessesIsFree;
    /**
     * Object of Queue
     */
    private Queue queue;
    /**
     * Speed of process
     */
    private int speed = 1;
    /**
     * Quantity processes left
     */
    private int quantityProcessesLeft = 0;
    /**
     * Average process wait
     */
    private  int  averageProcessWait = 0;
    /**
     * Average process time
     */
    private  int averageProcessTime = 0;

    public int getAverageProcessTime() {
        return averageProcessTime;
    }

    public void setAverageProcessTime(final int averageProcessTime) {
        this.averageProcessTime = averageProcessTime;
    }

    public int getAverageProcessWait() {
        return averageProcessWait;
    }

    public void setAverageProcessWait(final int averageProcessWait) {
        this.averageProcessWait = averageProcessWait;
    }

    public int getQuantityProcessesLeft() {
        return quantityProcessesLeft;
    }

    public void setQuantityProcessesLeft(final int quantityProcessesLeft) {
        this.quantityProcessesLeft = quantityProcessesLeft;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }

   public CreatRunningProcesses() {
        createRunningProcesses = new ArrayList<>();
        queue = new Queue();
        for (int i = 0; i < Configuration.quantityRunningProcesses; i++) {
            createRunningProcesses.add(null);
        }
        runningProcessesIsFree = new ArrayList<>();
        for (int i = 0; i < Configuration.quantityRunningProcesses; i++) {
            runningProcessesIsFree.add(Boolean.TRUE);
        }
    }

    /**
     * Get runningProcessesIsFree
     * @return runningProcessesIsFree
     */

    public ArrayList<Boolean> getRunningProcessesIsFree() {
        return runningProcessesIsFree;
    }

    /**
     * Get queue
     * @return queue
     */
    public Queue getQueue() {
        return queue;
    }

    /**
     * Add processes to queue, and creat ready queue
     */
    public void addQueue() {
        queue.add(20);
        queue.createReadyQueue();
    }

    /**
     * Get creat processes
     * @return creat processes
     */
    public ArrayList<RunningProcess> getCreateRunningProcesses() {
        return createRunningProcesses;
    }

    /**
     * Get finished queue
     * @return finished queue
     */
    public FinishedQueue getFinishedQueue() {
        return queue.getFinishedQueue();
    }
}
