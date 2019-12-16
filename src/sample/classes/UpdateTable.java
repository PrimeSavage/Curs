package sample.classes;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Class UpdateTable
 */
public class UpdateTable extends TimerTask {
    /**
     * Variable timer
     */
    private Timer timer = new Timer();

    @Override
    public void run() {
        timer.schedule(new UpdateTable(), 1000);
        Controller.updateTableReadyQueue();
        Controller.updateTableRejectQueue();
        Controller.updateTableFinishedQueue();
    }
}
