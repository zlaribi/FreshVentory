package de.iav.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FreshVentoryApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FreshVentoryApplication.class.getResource("/de/iav/frontend/fxml/login-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 780);
        stage.setTitle("Login page");
        stage.setScene(scene);
        stage.show();
    }
}
