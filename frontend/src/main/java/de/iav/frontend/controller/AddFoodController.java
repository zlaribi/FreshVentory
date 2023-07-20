package de.iav.frontend.controller;

import de.iav.frontend.model.Food;
import de.iav.frontend.model.FoodWithoutId;
import de.iav.frontend.service.FoodService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddFoodController implements Initializable {
    private Scene scene;
    private Parent root;
    private Stage stage;

    private final FoodService foodService = FoodService.getInstance();
    @FXML
    private Button backToMainSceneButton;
    @FXML
    private TextField nameOfFood;
    @FXML
    private ChoiceBox<String> categoryChoiceBox = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> quantityChoiceBox = new ChoiceBox<>();
    @FXML
    private DatePicker expirationDate;
    @FXML
    private Button saveButton;

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

    @FXML
    protected void saveNewFoodButton() {
        FoodWithoutId newFood = new FoodWithoutId(nameOfFood.getText(), quantityChoiceBox.getValue(), categoryChoiceBox.getItems(), expirationDate.getValue());
        foodService.addFood(newFood);
        //saveButton.setOnAction(e -> switchToMainScene());
    }

    @FXML
    public void updateFood(Food foodToUpdate) {
        nameOfFood.setText(foodToUpdate.name());
        categoryChoiceBox.getItems().add(foodToUpdate.category().toString());
        quantityChoiceBox.getItems().add(foodToUpdate.quantity().toString());
        expirationDate.setValue(foodToUpdate.expirationDate());

    }

    @FXML
    protected void switchToMainScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/fxml/main-scene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
}
