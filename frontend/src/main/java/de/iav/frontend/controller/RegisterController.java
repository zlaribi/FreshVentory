package de.iav.frontend.controller;

import de.iav.frontend.FreshVentoryApplication;
import de.iav.frontend.security.AppUserRequest;
import de.iav.frontend.security.AuthService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    public TextField usernameInput;
    @FXML
    public TextField emailInput;
    @FXML
    public PasswordField passwordInput;
    @FXML
    public Label errorLabel;

    @FXML
    protected void onRegisterClick() {
        register();
    }

    private final AuthService authService = AuthService.getInstance();

    public void register() {

        AppUserRequest appUserRequest = new AppUserRequest(
                usernameInput.getText(),
                emailInput.getText(),
                passwordInput.getText()
        );

        if (authService.registerAppUser(appUserRequest)) {
            FXMLLoader fxmlLoader = new FXMLLoader(FreshVentoryApplication.class.getResource("login-scene.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Scene scene = new Scene(root);
            Stage stage = (Stage) usernameInput.getScene().getWindow();
            stage.setScene(scene);

        } else {
            errorLabel.setText(authService.getErrorMessage());
        }
    }
}