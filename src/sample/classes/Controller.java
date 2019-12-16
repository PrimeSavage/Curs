package sample.classes;

import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Class Controller
 */
public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    /**
     * Table view of ready queue
     */
    @FXML
    private TableView<Table> processTableReadyQueue;
    /**
     * Table column of process id
     */
    @FXML
    private TableColumn<Table, Integer> processIdReadyQueue;
    /**
     * Table column of process of name
     */

    @FXML
    private TableColumn<Table, String> processNameReadyQueue;
    /**
     * Table column of process priority
     */
    @FXML
    private TableColumn<Table, Integer> processPriorityReadyQueue;
    /**
     * Table column of process time
     */
    @FXML
    private TableColumn<Table, Integer> processTimeReadyQueue;
    /**
     * Table column of process memory
     */

    @FXML
    private TableColumn<Table, Integer> processMemoryReadyQueue;
    /**
     * Table column of process time in
     */

    @FXML
    private TableColumn<Table, Integer> processTimeInReadyQueue;
    /**
     * Table column of process burst time
     */

    @FXML
    private TableColumn<Table, Integer> processBurstTimeReadyQueue;
    /**
     * Table column of process state
     */

    @FXML
    private TableColumn<Table, String> processStateReadyQueue;
    /**
     * Table view of reject queue
     */
    @FXML
    private TableView<Table> processTableRejectQueue;
    /**
     * Table column of process id
     */
    @FXML
    private TableColumn<Table, Integer> processIdRejectQueue;
    /**
     * Table column of process of name
     */
    @FXML
    private TableColumn<Table, String> processNameRejectQueue;
    /**
     * Table column of process priority
     */
    @FXML
    private TableColumn<Table, Integer> processPriorityRejectQueue;
    /**
     * Table column of process time
     */
    @FXML
    private TableColumn<Table, Integer> processTimeRejectQueue;
    /**
     * Table column of process memory
     */
    @FXML
    private TableColumn<Table, Integer> processMemoryRejectQueue;
    /**
     * Table column of process time in
     */
    @FXML
    private TableColumn<Table, Integer> processTimeInRejectQueue;
    /**
     * Table column of process burst time
     */
    @FXML
    private TableColumn<Table, Integer> processBurstTimeRejectQueue;
    /**
     * Table column of process state
     */
    @FXML
    private TableColumn<Table, String> processStateRejectQueue;
    /**
     * Table view of finished queue
     */
    @FXML
    private TableView<Table> processTableFinishedQueue;
    /**
     * Table column of process id
     */
    @FXML
    private TableColumn<Table, Integer> processIdFinishedQueue;
    /**
     * Table column of process of name
     */
    @FXML
    private TableColumn<Table, String> processNameFinishedQueue;
    /**
     * Table column of process priority
     */
    @FXML
    private TableColumn<Table, Integer> processPriorityFinishedQueue;
    /**
     * Table column of process time
     */
    @FXML
    private TableColumn<Table, Integer> processTimeFinishedQueue;
    /**
     * Table column of process memory
     */
    @FXML
    private TableColumn<Table, Integer> processMemoryFinishedQueue;
    /**
     * Table column of process time in
     */
    @FXML
    private TableColumn<Table, Integer> processTimeInFinishedQueue;
    /**
     * Table column of process burst time
     */
    @FXML
    private TableColumn<Table, Integer> processBurstTimeFinishedQueue;
    /**
     * Table column of process state
     */
    @FXML
    private TableColumn<Table, String> processStateFinishedQueue;
    /**
     * name of process
     */
    private String name;

    /**
     * All processes quantity
     */
    @FXML
    private TextField allProcessesQuantity;
    /**
     * Quantity reject queue
     */

    @FXML
    private TextField quantityRejectQueue;
    /**
     * Quantity finished queue
     */
    @FXML
    private TextField quantityFinishedQueue;
    /**
     * Quantity processes left system
     */
    @FXML
    private TextField quantityProcessesLeftSystem;
    /**
     * Average service wait
     */
    @FXML
    private TextField averageServiceWait;
    /**
     * Processor idle cycles
     */
    @FXML
    private TextField processorIdleCycles;
    /**
     * Average waiting time for a process in a ready queue
     */
    @FXML
    private TextField averageProcessWait;
    /**
     * Average time of the process
     */
    @FXML
    private TextField averageProcessTime;

    /**
     * Object of RunningProcesses
     */
    private static RunningProcesses runningProcesses = new RunningProcesses();
    /**
     * Object of RefreshRunningProcesses
     */
    private RefreshRunningProcesses refreshRunningProcesses = new RefreshRunningProcesses(runningProcesses);
    /**
     * Object of UpdateTable
     */
    private UpdateTable updateTable = new UpdateTable();
    /**
     * Object of ObservableList
     */
    private static ObservableList<Table> dataReadyQueue = FXCollections.observableArrayList();
    /**
     * Object of ObservableList
     */
    private static ObservableList<Table> dataRejectQueue = FXCollections.observableArrayList();
    /**
     * Object of ObservableList
     */
    private static ObservableList<Table> dataFinishedQueue = FXCollections.observableArrayList();


    /**
     * Initialize of Controller
     */
    @FXML
    public void initialize() {
        processIdReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processId"));
        processNameReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processName"));
        processPriorityReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processPriority"));
        processTimeReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTime"));
        processMemoryReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processMemory"));
        processTimeInReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTimeIn"));
        processBurstTimeReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processBurstTime"));
        processStateReadyQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processState"));
        processIdRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processId"));
        processNameRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processName"));
        processPriorityRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processPriority"));
        processTimeRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTime"));
        processMemoryRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processMemory"));
        processTimeInRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTimeIn"));
        processBurstTimeRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processBurstTime"));
        processStateRejectQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processState"));
        processIdFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processId"));
        processNameFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processName"));
        processPriorityFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processPriority"));
        processTimeFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTime"));
        processMemoryFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processMemory"));
        processTimeInFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processTimeIn"));
        processBurstTimeFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, Integer>("processBurstTime"));
        processStateFinishedQueue.setCellValueFactory(new PropertyValueFactory<Table, String>("processState"));
        processTableReadyQueue.setItems(dataReadyQueue);
        processTableRejectQueue.setItems(dataRejectQueue);
        processTableFinishedQueue.setItems(dataFinishedQueue);
        refreshRunningProcesses.run();
        updateTable.run();
        Statistics();
    }
    /**
     * Update table of ready queue
     */
    public static void updateTableReadyQueue() {
        dataReadyQueue.clear();
        if (!runningProcesses.getCreateRunningProcesses().getQueue().getReadyQueue().getReadyQueue().isEmpty()) {
            try {
                for (final Process process : runningProcesses.getCreateRunningProcesses().getQueue().getReadyQueue().getReadyQueue()) {
                    dataReadyQueue.add(new Table(process));
                }
            } catch (ConcurrentModificationException e){} catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Update table of reject queue
     */
    public static void updateTableRejectQueue() {
        dataRejectQueue.clear();
        if (!runningProcesses.getCreateRunningProcesses().getQueue().getRejectQueue().getRejectQueue().isEmpty()) {
            try {
                for (final Process process : runningProcesses.getCreateRunningProcesses().getQueue().getRejectQueue().getRejectQueue()) {
                    dataRejectQueue.add(new Table(process));
                }
            } catch (ConcurrentModificationException e){}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Update table of finished queue
     */
    public static void updateTableFinishedQueue() {
        dataFinishedQueue.clear();
        if (!runningProcesses.getCreateRunningProcesses().getQueue().getFinishedQueue().getFinishedQueue().isEmpty()) {
            try {
                for (final Process process : runningProcesses.getCreateRunningProcesses().getFinishedQueue().getFinishedQueue()) {

                    dataFinishedQueue.add(new Table(process));
                }
            } catch (ConcurrentModificationException e){ } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void setPriority(final int priority) {
        final ArrayList<Process> processes = runningProcesses.getCreateRunningProcesses().getQueue().getReadyQueue().getReadyQueue();
        int i = 0;
        for (final Process process : processes) {
            i++;
            if (process.getName().equals(name)) {
                break;
            }
        }
        try {
            runningProcesses.getCreateRunningProcesses().getQueue().getReadyQueue().getReadyQueue().get(i).setPriority(priority);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Statistics() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (!runningProcesses.getCreateRunningProcesses().getQueue().getQueue().isEmpty()) {
                    allProcessesQuantity.setText(String.valueOf(runningProcesses.getCreateRunningProcesses().getQueue().getLastID()));
                }
                if (!runningProcesses.getCreateRunningProcesses().getQueue().getRejectQueue().getRejectQueue().isEmpty()) {
                    quantityRejectQueue.setText(String.valueOf(runningProcesses.getCreateRunningProcesses().getQueue().getRejectQueue().getQuantityRejectQueue()));
                }
                if (!runningProcesses.getCreateRunningProcesses().getQueue().getFinishedQueue().getFinishedQueue().isEmpty()) {
                    quantityFinishedQueue.setText(String.valueOf(runningProcesses.getCreateRunningProcesses().getFinishedQueue().getQuantityFinishedQueue()));
                }
                quantityProcessesLeftSystem.setText(String.valueOf(runningProcesses.getCreateRunningProcesses().getQuantityProcessesLeft()));
                if (runningProcesses.getCreateRunningProcesses().getQueue().getAverageServiceWait() != 0) {
                    averageServiceWait.setText(runningProcesses.getCreateRunningProcesses().getQueue().getAverageServiceWait() / runningProcesses.getCreateRunningProcesses().getQueue().getLastID() + " tact(s)");
                }
                processorIdleCycles.setText(runningProcesses.getProcessorIdleCycles() + " tact(s)");
                if (runningProcesses.getCreateRunningProcesses().getAverageProcessWait() != 0) {
                    averageProcessWait.setText(runningProcesses.getCreateRunningProcesses().getAverageProcessWait() / runningProcesses.getCreateRunningProcesses().getQueue().getReadyQueue().getQuantityReadyQueue() + " tact(s)");
                }
                if (runningProcesses.getCreateRunningProcesses().getAverageProcessTime() != 0) {
                    averageProcessTime.setText(runningProcesses.getCreateRunningProcesses().getAverageProcessTime() / runningProcesses.getCreateRunningProcesses().getFinishedQueue().getQuantityFinishedQueue() + " tact(s)");
                }
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(timerTask, delay, period);
    }
}
