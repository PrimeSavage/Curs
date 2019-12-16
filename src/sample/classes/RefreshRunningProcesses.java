package sample.classes;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Class RefreshRunningProcesses
 */
public class RefreshRunningProcesses extends TimerTask {
    /**
     * Variable timer
     */
    private Timer timer = new Timer();
    /**
     * Object of RunningProcesses
     */
    private RunningProcesses runningProcesses;

    /**
     * Constructor of refresh running processes
     * @param runningProcesses running processes
     */
    RefreshRunningProcesses(final RunningProcesses runningProcesses) {
        this.runningProcesses = runningProcesses;
    }

    @Override
    public void run() {
        timer.schedule(new RefreshRunningProcesses(runningProcesses), 1);
        ClockGenerator.incTime();
        runningProcesses.runProcess();
    }
}
