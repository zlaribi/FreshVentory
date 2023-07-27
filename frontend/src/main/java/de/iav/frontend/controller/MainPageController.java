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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class MainPageController {
    private Scene scene;
    private Parent root;
    private Stage stage;
    private final FoodService foodService = FoodService.getInstance();

    @FXML
    private Button deleteFoodById;
    @FXML
    private Button updateFoodButton;
    @FXML
    private TableView<Food> table;
    @FXML
    private TableColumn<Food, String> nameColumn;
    @FXML
    private TableColumn<Food, String> categoryColumn;
    @FXML
    private TableColumn<Food, String> quantityColumn;
    @FXML
    private TableColumn<Food, LocalDate> expirationDateColumn;

    public void initialize() {
        List<Food> allFood = foodService.getFoodList();
        table.getItems().clear();

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        expirationDateColumn.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));

        table.getItems().addAll(allFood);
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
        foodService.deleteFoodById(table.getSelectionModel().getSelectedItem().foodId(), table);
    }

    @FXML
    public void switchToUpdateFoodScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/de/iav/frontend/fxml/addfood-scene.fxml"));
        root = loader.load();

        Food foodToUpdate = table.getSelectionModel().getSelectedItem();
        AddFoodController addFoodController = loader.getController();
        addFoodController.setSelectedFood(foodToUpdate);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Food Page");
        stage.show();
    }
}