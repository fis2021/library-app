package lapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lapp.services.DatabaseService;
import lapp.services.FileSystemService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main extends Application{




    @Override
    public void start(Stage stage) throws Exception {
        //initDirectory();
        DatabaseService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Registration page");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

//    private void initDirectory() {
//        Path applicationHomePath = Paths.get(FileSystemService.USER_FOLDER, FileSystemService.APPLICATION_HOME_PATH);
//        if (!Files.exists(applicationHomePath))
//            applicationHomePath.toFile().mkdirs();
//    }

    public static void main(String[] args){
        launch(args);
    }

}
