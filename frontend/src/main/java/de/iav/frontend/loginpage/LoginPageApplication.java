package de.iav.frontend.loginpage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class LoginPageApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPageApplication.class.getResource("/de/iav/frontend/fxml/login-page.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 360, 780);
        stage.setTitle("Login page");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

/*    @Override
    public void start(Stage primaryStage) {
    }*/
}
