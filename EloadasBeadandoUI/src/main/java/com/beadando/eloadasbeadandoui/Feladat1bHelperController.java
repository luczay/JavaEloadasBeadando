package com.beadando.eloadasbeadandoui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Feladat1bHelperController {

    private static List<RendelesExpanded> results;

    @FXML
    private TableView<RendelesExpanded> rendelesTable;

    @FXML
    private TableColumn<RendelesExpanded, String> kategoriaNevColumn;

    @FXML
    private TableColumn<RendelesExpanded, Integer> kategoriaArColumn;

    @FXML
    private TableColumn<RendelesExpanded, String> pizzaNevColumn;

    @FXML
    private TableColumn<RendelesExpanded, Boolean> vegetarianusColumn;

    @FXML
    private TableColumn<RendelesExpanded, Integer> rendelesAzColumn;

    @FXML
    private TableColumn<RendelesExpanded, Integer> darabColumn;

    @FXML
    private TableColumn<RendelesExpanded, Date> felvetelColumn;

    @FXML
    private TableColumn<RendelesExpanded, Date> kiszallitasColumn;

    @FXML
    protected void initialize() {
        kategoriaNevColumn.setCellValueFactory(new PropertyValueFactory<>("kategoriaNev"));
        kategoriaArColumn.setCellValueFactory(new PropertyValueFactory<>("kategoriaAr"));
        pizzaNevColumn.setCellValueFactory(new PropertyValueFactory<>("pizzaNev"));
        vegetarianusColumn.setCellValueFactory(new PropertyValueFactory<>("vegetarianus"));
        rendelesAzColumn.setCellValueFactory(new PropertyValueFactory<>("rendelesAz"));
        darabColumn.setCellValueFactory(new PropertyValueFactory<>("darab"));
        felvetelColumn.setCellValueFactory(new PropertyValueFactory<>("felvetel"));
        kiszallitasColumn.setCellValueFactory(new PropertyValueFactory<>("kiszallitas"));

        loadTableData();
    }

    public static void setResults(List<RendelesExpanded> resultList) {
        Feladat1bHelperController.results = resultList;
    }

    private void loadTableData() {
        ObservableList<RendelesExpanded> observableResults = FXCollections.observableArrayList(results);
        rendelesTable.setItems(observableResults);
    }

    public void onBackToMenuClick(ActionEvent event) {
        try {
            BeadandoUIApplication.switchScene("main-menu.fxml", "Főmenü");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
