package com.beadando.eloadasbeadandoui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Feladat1bHelperController {

    @FXML
    protected void initialize() {
        // Set up the table columns for displaying results
        //kategoriaNevColumn.setCellValueFactory(new PropertyValueFactory<>("kategoriaNev"));
    }

    public void onBackToMainMenu(ActionEvent event) {
        try {
            BeadandoUIApplication.switchScene("main-menu.fxml", "Főmenü");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
