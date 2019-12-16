package sample.classes;

/**
 * Class RunningProcess
 */
public class RunningProcess extends Thread {
    /**
     * Object of Process
     */
    private Process process;
    /**
     * index
     */
    private int index;
    /**
     * Object of  CreatRunningProcesses
     */
    private CreatRunningProcesses creatRunningProcesses;
    /**
     * priority
     */
    private int time = 0;

    RunningProcess(final Process process, final int index, final CreatRunningProcesses creatRunningProcesses) {
        this.process = process;
        this.index = index;
        this.creatRunningProcesses = creatRunningProcesses;
    }

    RunningProcess(final Process process, final int index, final CreatRunningProcesses creatRunningProcesses, final int time) {
        this.process = process;
        this.index = index;
        this.creatRunningProcesses = creatRunningProcesses;
        this.time = time;
    }

    @Override
    public void run() {
        creatRunningProcesses.setAverageProcessWait(ClockGenerator.getTime() - process.getTimeInReadyQueue());
        process.setState(sample.classes.State.Running);
        try {
            sleep(process.getTime() / creatRunningProcesses.getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (time != 0) {
            if (time > process.getTime()) {
                process.setBurstTime(ClockGenerator.getTime());
                process.setState(sample.classes.State.Finished);
                creatRunningProcesses.setAverageProcessTime(process.getBurstTime() - process.getTimeIn());
                creatRunningProcesses.getQueue().getMemoryScheduler().releaseMemoryBlock(process.getMemoryBlock());
                creatRunningProcesses.getFinishedQueue().addFinishedQueue(process);
            } else {
                creatRunningProcesses.getQueue().getReadyQueue().getReadyQueue().add(process);
            }
        } else {
            process.setBurstTime(ClockGenerator.getTime());
            process.setState(sample.classes.State.Finished);
            creatRunningProcesses.setAverageProcessTime(process.getBurstTime() - process.getTimeIn());
            creatRunningProcesses.getQueue().getMemoryScheduler().releaseMemoryBlock(process.getMemoryBlock());
            creatRunningProcesses.getFinishedQueue().addFinishedQueue(process);
        }
        creatRunningProcesses.getRunningProcessesIsFree().set(index, Boolean.TRUE);
    }
}
