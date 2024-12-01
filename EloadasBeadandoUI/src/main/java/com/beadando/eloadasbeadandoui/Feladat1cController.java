package com.beadando.eloadasbeadandoui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class Feladat1cController {

    @FXML
    private TextField pizzaNevField;

    @FXML
    private ComboBox<String> kategoriaDropdown;

    @FXML
    private CheckBox vegetarianusCheckBox;

    @FXML
    public void initialize() {
        loadKategoriaDropdown();
    }

    private void loadKategoriaDropdown() {
        List<String> categoryNames = DbManager.getAllCategoryNames();
        if (categoryNames != null && !categoryNames.isEmpty()) {
            kategoriaDropdown.setItems(FXCollections.observableArrayList(categoryNames));
        } else {
            System.out.println("Failed to load categories or no categories found.");
        }
    }

    @FXML
    protected void onAddPizzaClick() {
        String pizzaNev = pizzaNevField.getText();
        String kategoriaNev = kategoriaDropdown.getValue();
        boolean vegetarianus = vegetarianusCheckBox.isSelected();

        if (pizzaNev == null || kategoriaNev == null) {
            System.out.println("All fields must be filled out.");
            return;
        }

        try {
            DbManager.createPizza(pizzaNev, kategoriaNev, vegetarianus);
            System.out.println("Pizza successfully added!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to add pizza.");
        }
    }

    @FXML
    protected void onBackToMenuClick() throws IOException {
        BeadandoUIApplication.switchScene("main-menu.fxml", "Main Menu");
    }
}
