package control;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class SettingsController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button confirmButton;
    @FXML
    private ComboBox<?> deletionComboBox;
    @FXML
    private Button exportButton;
    @FXML
    private ComboBox<?> themeComboBox;

    @FXML
    void changeColorTheme(ActionEvent event) {

    }

    @FXML
    void changeDeletionConfirmation(ActionEvent event) {

    }

    @FXML
    void exitWithoutSaving(ActionEvent event) {

    }

    @FXML
    void exportToPdf(ActionEvent event) {

    }

    @FXML
    void saveChanges(ActionEvent event) {

    }

}
