package Controller.helper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowWorker {
    public void openWindow(String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(path));
        Stage stage = new Stage();
        String title;
        if(path == "fxml/journal.fxml"){
            title = "Дневник";
        }
        else {
            title = "Ввод заметки";
        }
        stage.setTitle(title);
        stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight()));
        stage.show();
    }

    public void closeWindow(Button button){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }


}
