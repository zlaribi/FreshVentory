package de.iav.frontend.controller;

import de.iav.frontend.exception.CustomIOException;
import de.iav.frontend.security.AuthService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent parent;

    @FXML
    private TextField usernameInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private Label errorLabel;

    private final AuthService authService = AuthService.getInstance();

    @FXML
    protected void onLoginClick() {
        login();
    }

    @FXML
    private void login() {
        if (authService.login(usernameInput.getText(), passwordInput.getText())) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/iav/frontend/fxml/main-scene.fxml"));

            try {
                parent = fxmlLoader.load();
            } catch (Exception e) {
                throw new CustomIOException(e.toString());

            }

            scene = new Scene(parent);
            stage = (Stage) usernameInput.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Main Page");
        } else {
            errorLabel.setText(authService.errorMessage());
        }
    }

    @FXML
    protected void onRegisterClick() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/iav/frontend/fxml/register-scene.fxml"));

        try {
            parent = fxmlLoader.load();
        } catch (Exception e) {
            throw new CustomIOException(e.toString());
        }

        scene = new Scene(parent);
        stage = (Stage) usernameInput.getScene().getWindow();
        stage.setScene(scene);
    }
}


