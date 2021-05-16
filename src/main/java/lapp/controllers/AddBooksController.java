package lapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapp.services.BookstoreService;

import java.awt.event.ActionEvent;
import java.io.IOException;


public class AddBooksController {
    @FXML
    private TextField title;

    @FXML
    private TextField author;

    @FXML
    private TextField description;

    @FXML
    private TextField pHouse;

    @FXML
    private Button done;

    @FXML
    private Label addingBookMessage;

    @FXML
    private Button back;

    @FXML
    void goBackToHomepageLibrarian(ActionEvent event) throws IOException{
        Parent registerParent = FXMLLoader.load(getClass().getClassLoader().getResource("HomepageLibrarian.fxml"));
        Scene registerScene = new Scene(registerParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(registerScene);
        window.show();
    }

    @FXML
    void handleAddingBooksAction(ActionEvent event) {
        BookstoreService.addBook(title.getText(), author.getText(), pHouse.getText(), description.getText());
        addingBookMessage.setText("Account created!");
    }

}
