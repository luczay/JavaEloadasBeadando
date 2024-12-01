package com.beadando.eloadasbeadandoui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BeadandoUIController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}