package com.beadando.eloadasbeadandoui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class Feladat1dController {

    @FXML
    private ComboBox<String> pizzaDropdown;

    @FXML
    private TextField pizzaNevField;

    @FXML
    private ComboBox<String> kategoriaDropdown;

    @FXML
    private CheckBox vegetarianusCheckBox;

    private Pizza selectedPizza;

    @FXML
    public void initialize() {
        // Load Pizza names into dropdown
        loadPizzaDropdown();

        // Load Kategoria names into dropdown
        loadKategoriaDropdown();

        // Add listener for pizzaDropdown selection
        pizzaDropdown.setOnAction(event -> onPizzaSelected());
    }

    private void loadPizzaDropdown() {
        List<String> pizzaNames = DbManager.getAllPizzaNames(); // Add this query to DbManager
        if (pizzaNames != null && !pizzaNames.isEmpty()) {
            pizzaDropdown.setItems(FXCollections.observableArrayList(pizzaNames));
        } else {
            System.out.println("No pizzas found or failed to load.");
        }
    }

    private void loadKategoriaDropdown() {
        List<String> categoryNames = DbManager.getAllCategoryNames();
        if (categoryNames != null && !categoryNames.isEmpty()) {
            kategoriaDropdown.setItems(FXCollections.observableArrayList(categoryNames));
        } else {
            System.out.println("No categories found or failed to load.");
        }
    }

    private void onPizzaSelected() {
        String selectedPizzaName = pizzaDropdown.getValue();
        if (selectedPizzaName != null) {
            // Fetch pizza details from database
            selectedPizza = DbManager.getPizzaDetails(selectedPizzaName); // Add this query to DbManager
            if (selectedPizza != null) {
                pizzaNevField.setText(selectedPizza.getNev());
                kategoriaDropdown.setValue(selectedPizza.getKategorianev());
                vegetarianusCheckBox.setSelected(selectedPizza.isVegetarianus());
            }
        }
    }

    @FXML
    protected void onSubmitClick() {
        if (selectedPizza == null) {
            System.out.println("No pizza selected.");
            return;
        }

        String newPizzaNev = pizzaNevField.getText();
        String newKategoriaNev = kategoriaDropdown.getValue();
        boolean newVegetarianus = vegetarianusCheckBox.isSelected();

        try {
            // Update pizza in the database
            DbManager.modifyPizza(selectedPizza.getNev(), newKategoriaNev, newVegetarianus);
            System.out.println("Pizza successfully updated!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to update pizza.");
        }
    }

    @FXML
    protected void onBackToMenuClick() throws IOException {
        BeadandoUIApplication.switchScene("main-menu.fxml", "Main Menu");
    }
}
