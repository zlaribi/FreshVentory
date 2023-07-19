package de.iav.frontend.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainPageController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onLoginButtonClick() {
        welcomeText.setText("Welcome to FreshVentory!");
    }

    public MainPageController(){
    }

}