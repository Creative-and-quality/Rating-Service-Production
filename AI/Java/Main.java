package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage primaryStage;
    FXMLLoader fxmlLoader;
    Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("personality.fxml"));

        Parent fxmlMain = fxmlLoader.load();
        controller = fxmlLoader.getController();
        controller.setMainStage(primaryStage);
        primaryStage.close();

        primaryStage.setTitle("Справочник Личности");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(700);
        primaryStage.setScene(new Scene(fxmlMain, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
