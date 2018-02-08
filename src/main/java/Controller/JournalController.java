package Controller;

import Controller.helper.WindowWorker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import type.Journal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static SQLConnector.QueryDB.queryDB;

public class JournalController implements Initializable {
    @FXML
    TableView<Journal> tableView;
    @FXML
    private Button saveNoteButton;
    @FXML
    private Button exitButton;

    /**
     * Инициация
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Thread sqlThread =new Thread(new Runnable() {
            @Override
            public void run() {
                tableView.getItems().addAll(queryDB());
            }
        });
        sqlThread.start();
        sqlThread.interrupt();
    }

    /**
     * Открывет окно для ввода заметки
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        WindowWorker windowWorker = new WindowWorker();
        windowWorker.closeWindow(saveNoteButton);
        windowWorker.openWindow("fxml/input.fxml");
    }

    /**
     * Выход из прилжения
     * @param event
     * @throws IOException
     */
    @FXML
    private void exitApplication(ActionEvent event) throws IOException {
        WindowWorker windowWorker = new WindowWorker();
        windowWorker.closeWindow(exitButton);
    }
}
