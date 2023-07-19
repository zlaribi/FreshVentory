package de.iav.frontend.controller;

import de.iav.frontend.model.Food;
import de.iav.frontend.service.FoodService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class MainPageController {
    private Scene scene;
    private Parent root;
    private Stage stage;
    private final FoodService foodService = new FoodService();
    private ListView<Food> listView;

    public void initialize() {
        List<Food> allFood = foodService.getFoodList();
        listView.getItems().addAll(allFood);

        listView.getSelectionModel().selectedItemProperty()
                .addListener(
                        (observableValue, s, t1) -> {
                            text.setText(listView.getSelectionModel().getSelectedItem().firstName() + " " + listView.getSelectionModel().getSelectedItem().lastName());
                            editStudentButton.setDisable(false);
                            deleteStudentButton.setDisable(false);
                        }
                );
    }

    @FXML
    public void switchToAddFoodScene(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addfood-scene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add your food");
        stage.show();
    }

    @FXML
    public void switchToCheckDateScene(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsumeBeforeController-scene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Consume Before");
        stage.show();
    }

    @FXML
    public void deleteFoodById(ActionEvent event) throws IOException {
        System.out.println("Delete your food.");
    }

    @FXML
    public void updateFoodById(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addfood-scene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Food Page");
        stage.show();
    }

}