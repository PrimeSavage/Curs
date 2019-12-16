package sample.classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Class Table
 */
public class Table {
    /**
     * Id of process
     */
    private final SimpleIntegerProperty processId;
    /**
     * Name of process
     */
    private final SimpleStringProperty processName;
    /**
     * Priority of process
     */
    private final SimpleIntegerProperty processPriority;
    /**
     * Time of process
     */
    private final SimpleIntegerProperty processTime;
    /**
     * Memory of process
     */
    private final SimpleIntegerProperty processMemory;
    /**
     * Time in of process
     */
    private final SimpleIntegerProperty processTimeIn;
    /**
     * Burst time of process
     */
    private final SimpleIntegerProperty processBurstTime;
    /**
     * Sate of process
     */
    private final SimpleStringProperty processState;

    /**
     * Constructor of Table
     * @param process process
     */
    Table(final Process process) {
        this.processId = new SimpleIntegerProperty(process.getId());
        this.processName = new SimpleStringProperty(process.getName());
        this.processPriority = new SimpleIntegerProperty(process.getPriority());
        this.processTime = new SimpleIntegerProperty(process.getTime());
        this.processMemory = new SimpleIntegerProperty(process.getMemory());
        this.processTimeIn = new SimpleIntegerProperty(process.getTimeIn());
        this.processBurstTime = new SimpleIntegerProperty(process.getBurstTime());
        this.processState = new SimpleStringProperty(process.getState().toString());
    }


    public int getProcessId() {
        return processId.get();
    }


    public SimpleIntegerProperty processIdProperty() {
        return processId;
    }

    public void setProcessId(final int processId) {
        this.processId.set(processId);
    }

    public String getProcessName() {
        return processName.get();
    }

    public SimpleStringProperty processNameProperty() {
        return processName;
    }

    public void setProcessName(final String processName) {
        this.processName.set(processName);
    }

    public int getProcessPriority() {
        return processPriority.get();
    }

    public SimpleIntegerProperty processPriorityProperty() {
        return processPriority;
    }

    public void setProcessPriority(final int processPriority) {
        this.processPriority.set(processPriority);
    }

    public int getProcessTime() {
        return processTime.get();
    }

    public SimpleIntegerProperty processTimeProperty() {
        return processTime;
    }

    public void setProcessTime(final int processTime) {
        this.processTime.set(processTime);
    }

    public int getProcessMemory() {
        return processMemory.get();
    }

    public SimpleIntegerProperty processMemoryProperty() {
        return processMemory;
    }

    public void setProcessMemory(final int processMemory) {
        this.processMemory.set(processMemory);
    }

    public int getProcessTimeIn() {
        return processTimeIn.get();
    }

    public SimpleIntegerProperty processTimeInProperty() {
        return processTimeIn;
    }

    public void setProcessTimeIn(final int processTimeIn) {
        this.processTimeIn.set(processTimeIn);
    }

    public int getProcessBurstTime() {
        return processBurstTime.get();
    }

    public SimpleIntegerProperty processBurstTimeProperty() {
        return processBurstTime;
    }

    public void setProcessBurstTime(final int processBurstTime) {
        this.processBurstTime.set(processBurstTime);
    }

    public String getProcessState() {
        return processState.get();
    }

    public SimpleStringProperty processStateProperty() {
        return processState;
    }

    public void setProcessState(final String processState) {
        this.processState.set(processState);
    }
}
