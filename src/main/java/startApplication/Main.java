package startApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/journal.fxml"));
        primaryStage.setTitle("Дневник");
        Scene scene = new Scene(root,primaryStage.getWidth(),primaryStage.getHeight());
        scene.getStylesheets().add("/styles/styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
