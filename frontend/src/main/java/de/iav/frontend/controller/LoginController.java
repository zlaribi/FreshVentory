package de.iav.frontend.controller;

import de.iav.frontend.security.AuthService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private Label errorMessage;

    private final AuthService authService = AuthService.getInstance();

    @FXML
    protected void onLoginClick() {
        login();
    }

    @FXML
    private void login() {
        /*if(authService.login(usernameInput.getText(), passwordInput.getText()){

        }*/
    }


    @FXML
    protected void switchToMainScene(ActionEvent event) throws IOException {
        // System.out.println("Email address is: " + emailField.getText());
        //System.out.println("Password is: " + passwordField.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/fxml/main-scene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Page");
        stage.show();
    }
}


