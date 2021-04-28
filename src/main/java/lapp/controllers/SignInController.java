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
import lapp.model.User;
import lapp.services.UserService;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class SignInController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text logInMessage;

    private static User currentUser;

    @FXML
    public void handleSignInAction(ActionEvent event){
        try{
            UserService.checkCredentials(usernameField.getText(), passwordField.getText());
            logInMessage.setText("Login successful!");

            Parent homepageParent = load(getClass().getClassLoader().getResource("homepage.fxml"));
            Scene homepageScene = new Scene(homepageParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(homepageScene);
            window.show();
        }catch(WrongPasswordException e){
            logInMessage.setText(e.getMessage());
        }catch(AccountDoesNotExistException e){
            logInMessage.setText(e.getMessage());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeSceneRegister(ActionEvent event) throws IOException {   //goes to register scene
        Parent registerParent = FXMLLoader.load(getClass().getClassLoader().getResource("SignUp.fxml"));
        Scene registerScene = new Scene(registerParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(registerScene);
        window.show();
    }

    public static User getCurrentUser() {
        return currentUser;
    }

}
