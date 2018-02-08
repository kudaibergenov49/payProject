package Controller;

import Controller.helper.ChangeListener;
import Controller.helper.WindowWorker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.io.IOException;
import static SQLConnector.QueryDB.insertIntoDB;

public class InputController {
    @FXML
    private Label currentData;
    @FXML
    private TextArea yourNote;
    @FXML
    private Button saveNoteButton;
    @FXML
    private Button backFWindow;

    /**
     * инициализация
     */
    @FXML
    private void initialize() {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
        currentData.setText(sqlDate.toString() + " " + sqlTime.toString());
        int maxLength = 100;
        yourNote.textProperty().addListener(new ChangeListener(yourNote,maxLength));
    }

    /**
     * Записывает в БД запись, возвращает к окну записей
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    private void addNoteAction(ActionEvent actionEvent) throws IOException {
        Thread sqlThread =new Thread(new Runnable() {
            @Override
            public void run() {
                insertIntoDB(yourNote.getText(), currentData.getText());
            }
        });
        sqlThread.start();
        sqlThread.interrupt();

        WindowWorker windowWorker = new WindowWorker();
        windowWorker.closeWindow(saveNoteButton);
        windowWorker.openWindow("fxml/journal.fxml");
    }

    /**
     * Возвращает к Главному окну со списком записей
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    private void backFWindow(ActionEvent actionEvent) throws IOException {
        WindowWorker windowWorker = new WindowWorker();
        windowWorker.closeWindow(backFWindow);
        windowWorker.openWindow("fxml/journal.fxml");
    }
}
