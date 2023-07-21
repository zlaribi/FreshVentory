package de.iav.frontend.controller;

import de.iav.frontend.model.Food;
import de.iav.frontend.service.FoodService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class MainPageController {
    private Scene scene;
    private Parent root;
    private Stage stage;
    private final FoodService foodService = FoodService.getInstance();


    @FXML
    private ListView<Food> listAllFood;
    @FXML
    private Button deleteFoodById;
    @FXML
    private Button updateFoodButton;


    public void initialize() {
        List<Food> allFood = foodService.getFoodList();
        listAllFood.getItems().addAll(allFood);
        listAllFood.getSelectionModel().selectedItemProperty()
                .addListener(
                        (observableValue, s, t1) -> {
                            updateFoodButton.setDisable(t1 == null);
                            deleteFoodById.setDisable(false);
                        }
                );
    }

    @FXML
    public void switchToAddFoodScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/fxml/addfood-scene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add your food");
        stage.show();
    }

    @FXML
    public void switchToCheckDateScene(ActionEvent event) throws IOException {
        System.out.println("check date");
    }

    @FXML
    public void deleteFoodById(ActionEvent event) throws IOException {
        foodService.deleteFoodById(listAllFood.getSelectionModel().getSelectedItem().foodId(), listAllFood);
    }

    @FXML
    public void switchToUpdateFoodScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/fxml/addfood-scene.fxml"));
        root = loader.load();

        Food foodToUpdate = listAllFood.getSelectionModel().getSelectedItem();
        AddFoodController addFoodController = loader.getController();
        addFoodController.setSelectedFood(foodToUpdate);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Food Page");
        stage.show();
    }
}