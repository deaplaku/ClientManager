module com.example.clientmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires com.fasterxml.jackson.annotation;

    opens com.example.clientmanager to javafx.fxml;
    exports com.example.clientmanager;
    exports control;
    exports model;

    opens control to javafx.fxml;
}