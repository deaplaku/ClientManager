package control;

import DAO.ClientDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Client;

import java.sql.SQLException;

public class NewClientController {

    @FXML
    private Button cancelButton;
    @FXML
    private TextField companyTextbox;
    @FXML
    private TextField nameTextbox;
    @FXML
    private Button saveButton;
    @FXML
    private TextField surnameTextbox;
    ClientDAO clientDAO = new ClientDAO();

    @FXML
    void cancelClient(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveNewClient(ActionEvent event) {
        try {
            String name = nameTextbox.getText();
            String surname = surnameTextbox.getText();
            String company = companyTextbox.getText();

            Client newClient = new Client(name, surname);
            if (company != null)
                newClient.setCompany(company);

            clientDAO.addClient(newClient);

            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}