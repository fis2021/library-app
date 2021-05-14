package lapp.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SeePastOrders extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SeePastOrders.fxml"));

        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);

        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add("CSS/newCascadeStyleSheet.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
