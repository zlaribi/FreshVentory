package de.iav.frontend.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    public Button loginButton;
    @FXML
    public TextField emailField;
    @FXML
    private PasswordField passwordField;

    public LoginController(){ //This is a controller
    }

    @FXML
    protected void onLoginButtonClick() {
        System.out.println("Email address is: " + emailField.getText());
        System.out.println("Password is: " + passwordField.getText());
    }
}

