package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button clientsButton;
    @FXML
    private Button dashboardButton;
    @FXML
    private Label doneNr;
    @FXML
    private Label inProgressNr;
    @FXML
    private ImageView logo;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button settingsButton;
    @FXML
    private PieChart taskChart;
    @FXML
    private Button tasksButton;
    @FXML
    private Label todoNr;
    @FXML
    private SplitMenuButton newButton;
    @FXML
    private MenuItem newClientButton;
    @FXML
    private MenuItem newTaskButton;

    //methods
    @FXML
    void goToClients(ActionEvent event) {
        loadView("/view/ClientsDesign.fxml");
    }

    @FXML
    void goToDashboard(ActionEvent event) {
        loadView("/view/FirstPage.fxml");
    }

    @FXML
    void goToTasks(ActionEvent event) {
        loadView("/view/TasksDesign.fxml");
    }

    @FXML
    void createNewClient(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CreateNewClient.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Create New Client");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(clientsButton.getScene().getWindow());
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void createNewTask(ActionEvent event) {
        System.out.println("createNewTask called");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CreateNewTask.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Create New Task");
            stage.setScene(new Scene(root));
            stage.sizeToScene();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(tasksButton.getScene().getWindow());
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openSettings(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/settings.fxml"));
            Parent settingsRoot = fxmlLoader.load();

            Stage settingsStage = new Stage();
            settingsStage.setTitle("Settings");
            settingsStage.setScene(new Scene(settingsRoot));
            settingsStage.initOwner(((Button) event.getSource()).getScene().getWindow());
            settingsStage.setResizable(false);
            settingsStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadView(String fxmlPath) {
        try {
            Parent view = FXMLLoader.load(getClass().getResource(fxmlPath));
            mainPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
