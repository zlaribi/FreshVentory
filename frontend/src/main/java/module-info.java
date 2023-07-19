module de.iav.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.net.http;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

    opens de.iav.frontend.addfoodpage to javafx.fxml;
    exports de.iav.frontend.addfoodpage;

    opens de.iav.frontend.consumebeforepage to javafx.fxml;
    exports de.iav.frontend.consumebeforepage;

    opens de.iav.frontend.loginpage to javafx.fxml;
    exports de.iav.frontend.loginpage;

    opens de.iav.frontend.mainpage to javafx.fxml;
    exports de.iav.frontend.mainpage;






}