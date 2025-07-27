package control;

import DAO.TaskDAO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Client;
import model.Task;

import java.sql.SQLException;
import java.util.List;

public class TasksController {

    @FXML
    private ComboBox<Client> clientComboBox;
    @FXML
    private DatePicker dateSelector;
    @FXML
    private CheckBox filterClient;
    @FXML
    private CheckBox filterDate;
    @FXML
    private CheckBox filterStatus;
    @FXML
    private TextField searchBar;
    /// table
    @FXML
    private TableView<Task> tasksTable;
    @FXML
    private TableColumn<Task, String> payStatusColumn;
    @FXML
    private TableColumn<Task, String> clientColumn;
    @FXML
    private TableColumn<Task, String> dateColumn;
    @FXML
    private TableColumn<Task, String> descColumn;
    @FXML
    private TableColumn<Task, Double> priceColumn;
    @FXML
    private TableColumn<Task, String> statusColumn;

    private final TaskDAO taskDAO = new TaskDAO();

    public void initialize(){
        clientColumn.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().getClient().getName() + " " + cellData.getValue().getClient().getSurname()
        ));
        dateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        priceColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrice()));
        descColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));
        statusColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus().toString()));
        payStatusColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPayStatus().toString()));

        loadTasksFromDb();
    }

    private void loadTasksFromDb() {
        try {
            List<Task> tasks = taskDAO.getAllTasks();
            tasksTable.getItems().setAll(tasks);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void filterToClient(ActionEvent event) {

    }

    @FXML
    void filterToDate(ActionEvent event) {

    }

    @FXML
    void filterToStatus(ActionEvent event) {

    }

    @FXML
    void searchTask(ActionEvent event) {

    }

}
