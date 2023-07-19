package de.iav.frontend.loginpage;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageController {
    @FXML
    public Button loginButton;
    @FXML
    public TextField emailField;
    @FXML
    private PasswordField passwordField;

    public LoginPageController(){
    }

    @FXML
    protected void onLoginButtonClick() {
        System.out.println("Email address is: " + emailField.getText());
        System.out.println("Password is: " + passwordField.getText());
    }
}