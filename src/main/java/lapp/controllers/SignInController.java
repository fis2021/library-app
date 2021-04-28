package lapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lapp.exceptions.AccountDoesNotExistException;
import lapp.exceptions.WrongPasswordException;
import lapp.services.UserService;

import java.io.IOException;

public class SignInController {

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Text loginMessage;

    @FXML
    public void handleLoginAction(){    //login button
        try{
            UserService.checkCredentials(usernameField.getText(), passwordField.getText());
            loginMessage.setText("Login successful!");
        }catch(WrongPasswordException e){
            loginMessage.setText(e.getMessage());
        }catch(NotExistingAccountException e){
            loginMessage.setText(e.getMessage());
        }
    }

    public void changeSceneRegister(ActionEvent event) throws IOException {   //goes to register scene
        Parent registerViewParent = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Scene registerViewScene = new Scene(registerViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(registerViewScene);
        window.show();
    }

}
