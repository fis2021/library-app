package lapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapp.exceptions.ShortPasswordException;
import lapp.exceptions.UsernameAlreadyExistsException;
import lapp.services.UserService;

import java.io.IOException;

public class CreateAccountController {

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField phoneField;
    @FXML
    private Label registrationMessage;

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(nameField.getText(), emailField.getText(), phoneField.getText(), usernameField.getText(), passwordField.getText());
            registrationMessage.setText("Account created!");
        } catch (ShortPasswordException e) {
            registrationMessage.setText(e.getMessage());
        } catch(UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());

        }
    }

    public void changeSceneLogin(ActionEvent event) throws IOException {   //goes to login scene
        Parent registerParent = FXMLLoader.load(getClass().getClassLoader().getResource("SignIn.fxml"));
        Scene registerScene = new Scene(registerParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(registerScene);
        window.show();
    }

}
