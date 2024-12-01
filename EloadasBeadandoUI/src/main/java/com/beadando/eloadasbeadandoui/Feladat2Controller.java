package com.beadando.eloadasbeadandoui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.application.Platform;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Feladat2Controller {

    @FXML
    private Label label1;
    @FXML
    private Label label2;

    private ExecutorService executor;

    @FXML
    public void initialize() {
        executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> changeLabelColor(label1, 1000));

        executor.submit(() -> changeLabelColor(label2, 2000));
    }

    private void changeLabelColor(Label label, int interval) {
        while (true) {
            try {
                Color randomColor = new Color(Math.random(), Math.random(), Math.random(), 1.0);

                Platform.runLater(() -> label.setStyle("-fx-font-size: 24px; -fx-background-color: " + toHexString(randomColor) + "; -fx-padding: 10px;"));

                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private String toHexString(Color color) {
        int r = (int) (color.getRed() * 255);
        int g = (int) (color.getGreen() * 255);
        int b = (int) (color.getBlue() * 255);
        return String.format("#%02X%02X%02X", r, g, b);
    }

    public void shutdownExecutor() {
        if (executor != null) {
            executor.shutdownNow();
        }
    }

    @FXML
    public void onClose() {
        shutdownExecutor();
    }

    public void onBackToMainMenu(ActionEvent event) {
        try {
            BeadandoUIApplication.switchScene("main-menu.fxml", "Főmenü");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
