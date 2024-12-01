package com.beadando.eloadasbeadandoui;

import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {
    @FXML
    protected void onFeladat1aClick() throws IOException {
        BeadandoUIApplication.switchScene("feladat1a.fxml", "1. Feladat - Olvas");
    }

    @FXML
    protected void onFeladat1bClick() throws IOException {
        BeadandoUIApplication.switchScene("feladat1b.fxml", "1. Feladat - Olvas2");
    }

    @FXML
    protected void onFeladat1cClick() throws IOException {
        BeadandoUIApplication.switchScene("feladat1c.fxml", "1. Feladat - Ír");
    }

    @FXML
    protected void onFeladat1dClick() throws IOException {
        BeadandoUIApplication.switchScene("feladat1d.fxml", "1. Feladat - Módosít");
    }

    @FXML
    protected void onFeladat1eClick() throws IOException {
        BeadandoUIApplication.switchScene("feladat1e.fxml", "1. Feladat - Töröl");
    }

    @FXML
    protected void onFeladat2Click() throws IOException {
        BeadandoUIApplication.switchScene("feladat3.fxml", "2. Feladat");
    }

    @FXML
    protected void onFeladat3Click() throws IOException {
        BeadandoUIApplication.switchScene("feladat2.fxml", "3. Feladat");
    }

    @FXML
    protected void onFeladat4Click() throws IOException {
        BeadandoUIApplication.switchScene("feladat4.fxml", "4. Feladat");
    }
}
