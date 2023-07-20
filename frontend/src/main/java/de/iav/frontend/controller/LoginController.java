package de.iav.frontend.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private Scene scene;
    private Parent root;
    private Stage stage;


    @FXML
    private Button loginButton;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    //public LoginController(){ //This is a controller
    //}

    @FXML
    protected void switchToMainScene(ActionEvent event) throws IOException {
        // System.out.println("Email address is: " + emailField.getText());
        //System.out.println("Password is: " + passwordField.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/fxml/main-scene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        //stage.setTitle("Main Page");
        //stage.show();


    }
}

