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
    private ListView<Food> listAllFood;
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

        //Clear existing items in t he TableView;
        table.getItems().clear();

        // Configure the TableColumns to use appropriate properties of the Food class
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        expirationDateColumn.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));


        // Add the sorted Food objects to the TableView
        table.getItems().addAll(allFood);
//
//        // Listener for the TableView selection (if needed)
//        table.getSelectionModel().selectedItemProperty()
//                .addListener((observableValue, oldValue, newValue) -> {
//                    if (newValue != null) {
//                        updateFoodButton.setDisable(false);
//                    } else {
//                        updateFoodButton.setDisable(true);
//                    }
//                    deleteFoodById.setDisable(false);
//                });
    }

    /*
        List<Food> allFood = foodService.getFoodList();
        listAllFood.getItems().addAll(allFood);
        listAllFood.getSelectionModel().selectedItemProperty()
                .addListener(
                        (observableValue, s, t1) -> {
                            if (t1 != null) {
                                updateFoodButton.setDisable(false);
                            } else {
                                updateFoodButton.setDisable(true);
                            }
                            deleteFoodById.setDisable(false);
                        }
                );
    }*/

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

        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsumeBeforeController-scene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Consume Before");
        stage.show();
    */
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
        addFoodController.updateFood(foodToUpdate);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Food Page");
        stage.show();
    }
}