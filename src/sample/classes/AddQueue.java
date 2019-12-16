package sample.classes;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Class AddQueue
 */
public class AddQueue extends TimerTask {
    /**
     * Variable timer
     */
    private Timer timer = new Timer();
    /**
     * Object of RunningProcess
     */
    private CreatRunningProcesses creatRunningProcesses;

    AddQueue(final CreatRunningProcesses creatRunningProcesses) {
        this.creatRunningProcesses = creatRunningProcesses;
    }

    @Override
    public void run() {
        timer.schedule(new AddQueue(creatRunningProcesses), 1500);
        creatRunningProcesses.addQueue();
    }
}
