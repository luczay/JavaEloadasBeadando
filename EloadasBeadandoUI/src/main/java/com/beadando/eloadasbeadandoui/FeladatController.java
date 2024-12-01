package com.beadando.eloadasbeadandoui;

import javafx.fxml.FXML;

import java.io.IOException;

public class FeladatController {
    @FXML
    protected void onBackToMenuClick() throws IOException {
        try {
            BeadandoUIApplication.switchScene("main-menu.fxml", "Főmenü");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
