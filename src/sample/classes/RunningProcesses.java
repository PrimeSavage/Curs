package sample.classes;

import java.util.ArrayList;
import java.util.Comparator;


class RunningProcesses {
    /**
     * Object of CreatRunningProcesses
     */
    private CreatRunningProcesses createRunningProcesses;
    /**
     * Processor idle cycles
     */
    private int processorIdleCycles = 0;

    RunningProcesses() {
        createRunningProcesses = new CreatRunningProcesses();
        final AddQueue addQueue = new AddQueue(createRunningProcesses);
        addQueue.run();
        ClearQueues clearQueues = new ClearQueues(createRunningProcesses);
        clearQueues.run();
    }

    /**
     * Get creat running processes
     *
     * @return creat running processes
     */
    public CreatRunningProcesses getCreateRunningProcesses() {
        return createRunningProcesses;
    }

    public int getProcessorIdleCycles() {
        return processorIdleCycles;
    }

    /**
     * Run of processes
     */
    public void runProcess() {
        Process runningProcess;
        final ArrayList<Process> tempProcesses = new ArrayList<>();
        for (int i = 0; i < Configuration.quantityRunningProcesses; i++) {
            if (createRunningProcesses.getRunningProcessesIsFree().get(i) == Boolean.TRUE) {
                if (!createRunningProcesses.getQueue().getReadyQueue().getReadyQueue().isEmpty()) {
                    createRunningProcesses.getRunningProcessesIsFree().set(i, Boolean.FALSE);
                    runningProcess = createRunningProcesses.getQueue().getReadyQueue().getReadyQueue().get(0);
                    createRunningProcesses.getQueue().getReadyQueue().getReadyQueue().remove(0);
                    tempProcesses.clear();
                    tempProcesses.addAll(createRunningProcesses.getQueue().getReadyQueue().getReadyQueue());
                    tempProcesses.sort(Comparator.comparingInt(Process::getPriority));
                    if (!tempProcesses.isEmpty()) {
                        createRunningProcesses.getCreateRunningProcesses().set(i, new RunningProcess(runningProcess, i, createRunningProcesses, tempProcesses.get(0).getTime()));
                    } else {
                        createRunningProcesses.getCreateRunningProcesses().set(i, new RunningProcess(runningProcess, i, createRunningProcesses));
                    }
                    createRunningProcesses.getCreateRunningProcesses().get(i).start();
                }
            }
        }
        if (createRunningProcesses.getQueue().getReadyQueue().getReadyQueue().isEmpty()){
            int checkFreeRunProcess = 0;
            for (int i = 0; i < Configuration.quantityRunningProcesses; i++) {
                if(createRunningProcesses.getRunningProcessesIsFree().get(i) == Boolean.TRUE){
                    checkFreeRunProcess++;
                }
            }
            if(checkFreeRunProcess == Configuration.quantityRunningProcesses){
                processorIdleCycles++;
            }
        }
    }
}
