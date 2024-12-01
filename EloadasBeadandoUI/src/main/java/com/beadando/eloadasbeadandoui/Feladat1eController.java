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
        // Load Pizza names into dropdown
        loadPizzaDropdown();
    }

    private void loadPizzaDropdown() {
        List<String> pizzaNames = DbManager.getAllPizzaNames(); // Reuse this query from DbManager
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
            // Delete pizza from the database
            DbManager.deletePizza(selectedPizzaName);
            System.out.println("Pizza successfully deleted!");
            pizzaDropdown.getItems().remove(selectedPizzaName); // Update UI
            pizzaDropdown.setValue(null); // Clear selection
        } catch (Exception e) {
        }
    }

    @FXML
    protected void onBackToMenuClick() throws IOException {
        BeadandoUIApplication.switchScene("main-menu.fxml", "Main Menu");
    }
}
