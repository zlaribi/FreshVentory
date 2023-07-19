package de.iav.frontend.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {
    private Scene scene;
    private Parent root;
    private Stage stage;


  //  @FXML
    //private Label welcomeText;

    @FXML
    public void addFoodButtonClick  (ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addFood-page.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Add Food Page");
        stage.show();
    }

@FXML
    public void checkDateClick  (ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsumeBeforeController-page.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Consume Before");
        stage.show();
    }


    @FXML
    public void deleteFoodById  (ActionEvent event) throws IOException {
        System.out.println("Essen bitte löschen");

            }
    @FXML
    public void updateFoodById  (ActionEvent event) throws IOException {
        System.out.println("Essen bitte ändern");

    }









}