package com.beadando.eloadasbeadandoui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BeadandoUIApplication extends Application {
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        switchScene("main-menu.fxml", "Főmenü");
    }

    public static void switchScene(String fxmlFile, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BeadandoUIApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setTitle(title);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
