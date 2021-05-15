package lapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lapp.services.BookstoreService;

import java.io.IOException;

public class LibrarianAddBooksController {
    @FXML
    private TextField title;

    @FXML
    private TextField author;

    @FXML
    private TextField pHouse;

    @FXML
    private TextField description;

    @FXML
    private Button done;

    @FXML
    private Button back;

    @FXML
    private Label addingBookMessage;

    //private static Book currentBook;

    @FXML
    public void openAddBook(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AddBooks.fxml"));

        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);

        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleAddingBooksAction(ActionEvent event){
        BookstoreService.addBook(title.getText(), author.getText(), pHouse.getText(), description.getText());
        addingBookMessage.setText("Book added!");
    }
    @FXML
    public void goBackToHomepageLibrarian(ActionEvent event) throws IOException {   //goes to homepageLibrarian scene
        Parent addBookParent = FXMLLoader.load(getClass().getClassLoader().getResource("HomepageLibrarian.fxml"));
        Scene addBookScene = new Scene(addBookParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(addBookScene);
        window.show();
    }
}
