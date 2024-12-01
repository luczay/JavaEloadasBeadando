package com.beadando.eloadasbeadandoui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private RadioButton categoryRadioButton;

    @FXML
    private VBox categoryRadioButtonsVBox;

    private ToggleGroup categoryToggleGroup;

    @FXML
    protected void initialize() {

        // Load pizza options into the ComboBox and set up the RadioButton
        List<String> pizzaNames = DbManager.getAllPizzaNames();
        pizzaComboBox.setItems(FXCollections.observableArrayList(pizzaNames));

        categoryToggleGroup = new ToggleGroup();

        List<String> categoryNames = DbManager.getAllCategoryNames();
        for (String categoryName : categoryNames) {
            RadioButton radioButton = new RadioButton(categoryName);
            radioButton.setToggleGroup(categoryToggleGroup);
            categoryRadioButtonsVBox.getChildren().add(radioButton);
        }
        // Set up the RadioButton with the available category names (this can be extended as needed)
    }

    @FXML
    protected void onSubmitClick() {
        String selectedPizza = pizzaComboBox.getValue();
        boolean vegetarianus = vegetarianCheckBox.isSelected();
        String selectedCategory = categoryRadioButton.getText(); // Use the value selected from the radio button if it's a group



        List<RendelesExpanded> result = DbManager.aggregateQuery(selectedPizza, vegetarianus, selectedCategory);


        // Display results in the table
        ObservableList<RendelesExpanded> observableList = FXCollections.observableArrayList(result);
    }

    public void onBackToMainMenu(ActionEvent event) {
        try {
            BeadandoUIApplication.switchScene("main-menu.fxml", "Főmenü");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
