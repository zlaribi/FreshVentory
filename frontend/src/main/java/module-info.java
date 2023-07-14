module de.iav.frontend {
    requires javafx.controls;
    requires javafx.fxml;

    opens de.iav.frontend.loginpage to javafx.fxml;
    exports de.iav.frontend.loginpage;

    opens de.iav.frontend.mainpage to javafx.fxml;
    exports de.iav.frontend.mainpage;


}