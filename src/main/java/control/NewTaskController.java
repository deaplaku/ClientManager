package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import DAO.*;
import javafx.stage.Stage;
import model.*;

import java.time.LocalDate;

public class NewTaskController  {

    @FXML
    private Button cancelButton;
    @FXML
    private Button confirmButton;
    @FXML
    private DatePicker dateSelector;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private ComboBox<Client> listOfClients;
    @FXML
    private TextField priceTextBox;
    @FXML
    private CheckBox todayCheckbox;
    @FXML
    private CheckBox tomorrowCheckbox;

    public void initialize() {
        try {
            ClientDAO clientDAO = new ClientDAO();
            listOfClients.getItems().addAll(clientDAO.getAllClients());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cancelTask(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveNewTask(ActionEvent event) {
        try {
            Client client = listOfClients.getValue();
            if (client == null)
                return;

            String description = descriptionTextArea.getText();
            LocalDate dueDate = dateSelector.getValue();
            double price = Double.parseDouble(priceTextBox.getText());

            Task newTask = new Task(client, description, dueDate, price);
            newTask.setStatus(TaskStatus.TODO);
            newTask.setPayStatus(PayStatus.UNPAID);

            TaskDAO taskDAO = new TaskDAO();
            taskDAO.addTask(newTask);

            Stage stage = (Stage) confirmButton.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void setDueDateToday(ActionEvent event) {
        dateSelector.setValue(LocalDate.now());
    }

    @FXML
    void setDueDateTomorrow(ActionEvent event) {
        dateSelector.setValue(LocalDate.now().plusDays(1));
    }

}
