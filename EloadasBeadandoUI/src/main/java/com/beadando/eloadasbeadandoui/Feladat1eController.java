package com.beadando.eloadasbeadandoui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.List;

public class Feladat1eController {

    @FXML
    private ComboBox<String> pizzaDropdown;

    @FXML
    public void initialize() {
        loadPizzaDropdown();
    }

    private void loadPizzaDropdown() {
        List<String> pizzaNames = DbManager.getAllPizzaNames();
        pizzaDropdown.setItems(FXCollections.observableArrayList(pizzaNames));
    }

    @FXML
    protected void onSubmitClick() {
        String selectedPizzaName = pizzaDropdown.getValue();
        if (selectedPizzaName == null || selectedPizzaName.isEmpty()) {
            System.out.println("No pizza selected.");
            return;
        }

        try {
            DbManager.deletePizza(selectedPizzaName);
            System.out.println("Pizza successfully deleted!");
            pizzaDropdown.getItems().remove(selectedPizzaName);
            pizzaDropdown.setValue(null);
        } catch (Exception e) {
        }
    }

    @FXML
    protected void onBackToMenuClick() throws IOException {
        BeadandoUIApplication.switchScene("main-menu.fxml", "Main Menu");
    }
}
