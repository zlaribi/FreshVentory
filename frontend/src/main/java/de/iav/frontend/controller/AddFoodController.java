package de.iav.frontend.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AddFoodController implements Initializable {
    @FXML
    private ChoiceBox<String> categoryChoiceBox = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> quantityChoiceBox = new ChoiceBox<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryChoiceBox.getItems().add("Fruits");
        categoryChoiceBox.getItems().add("Vegetables");
        categoryChoiceBox.getItems().add("Meat");
        categoryChoiceBox.getItems().add("Fish");
        categoryChoiceBox.getItems().add("Beverage");
        categoryChoiceBox.getItems().add("Eggs");
        categoryChoiceBox.getItems().add("Milk products");

        quantityChoiceBox.getItems().add("1");
        quantityChoiceBox.getItems().add("2");
        quantityChoiceBox.getItems().add("3");
        quantityChoiceBox.getItems().add("4");
        quantityChoiceBox.getItems().add("5");
        quantityChoiceBox.getItems().add("6");
        quantityChoiceBox.getItems().add("7");
        quantityChoiceBox.getItems().add("8");
        quantityChoiceBox.getItems().add("9");
        quantityChoiceBox.getItems().add("10");
    }
}

