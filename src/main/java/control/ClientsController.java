package control;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class ClientsController {

    @FXML
    private TableColumn<?, ?> clientId;
    @FXML
    private TableColumn<?, ?> clientName;
    @FXML
    private TableColumn<?, ?> clientNoTasks;
    @FXML
    private TableColumn<?, ?> clientStatus;
    @FXML
    private TableColumn<?, ?> clientSurname;
    @FXML
    private TextField searchBar;

    @FXML
    void searchClient(InputMethodEvent event) {

    }

}
