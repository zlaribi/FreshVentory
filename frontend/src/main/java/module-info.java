module de.iav.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.net.http;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires lombok;

    exports de.iav.frontend;
    opens de.iav.frontend to javafx.fxml;

    opens de.iav.frontend.controller to javafx.fxml;
    exports de.iav.frontend.controller;

    opens de.iav.frontend.model;
    //to javafx.fxml;
    exports de.iav.frontend.model;

    opens de.iav.frontend.service to javafx.fxml;
    exports de.iav.frontend.service;
    exports de.iav.frontend.security;
    opens de.iav.frontend.security to javafx.fxml;
}
