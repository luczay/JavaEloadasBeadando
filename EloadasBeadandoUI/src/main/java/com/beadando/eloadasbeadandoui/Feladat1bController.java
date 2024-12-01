package com.beadando.eloadasbeadandoui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class Feladat1bController {

    @FXML
    private ComboBox<String> pizzaComboBox;

    @FXML
    private CheckBox vegetarianCheckBox;

    @FXML
    private TextField dateInputField;

    @FXML
    private VBox categoryRadioButtonsVBox;

    private ToggleGroup categoryToggleGroup;

    @FXML
    protected void initialize() {
        // Load pizza options into the ComboBox
        List<String> pizzaNames = DbManager.getAllPizzaNames();
        pizzaComboBox.setItems(FXCollections.observableArrayList(pizzaNames));

        // Initialize the ToggleGroup for radio buttons
        categoryToggleGroup = new ToggleGroup();
        List<String> categoryNames = DbManager.getAllCategoryNames();
        for (String categoryName : categoryNames) {
            RadioButton radioButton = new RadioButton(categoryName);
            radioButton.setToggleGroup(categoryToggleGroup);
            categoryRadioButtonsVBox.getChildren().add(radioButton);
        }
    }

    @FXML
    protected void onSubmitClick() {
        String selectedPizza = pizzaComboBox.getValue();
        boolean vegetarianus = vegetarianCheckBox.isSelected();

        // Get the selected radio button's text
        RadioButton selectedCategoryButton = (RadioButton) categoryToggleGroup.getSelectedToggle();
        String selectedCategory = (selectedCategoryButton != null) ? selectedCategoryButton.getText() : null;

        // Validate inputs
        if (selectedPizza == null || selectedCategory == null) {
            // Handle validation (e.g., show an alert)
            showAlert("Error", "Kérem töltsön ki minden mezőt!");
            return;
        }

        // Query the database
        List<RendelesExpanded> result = DbManager.aggregateQuery(selectedPizza, vegetarianus, selectedCategory, dateInputField.getText());

        // Pass the result to the next scene (display in another FXML)
        try {
            Feladat1bHelperController.setResults(result); // Assuming ResultsController has a static method to set the results
            BeadandoUIApplication.switchScene("feladat1bhelper.fxml", "Eredmények");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void onBackToMainMenu(ActionEvent event) {
        try {
            BeadandoUIApplication.switchScene("main-menu.fxml", "Főmenü");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
