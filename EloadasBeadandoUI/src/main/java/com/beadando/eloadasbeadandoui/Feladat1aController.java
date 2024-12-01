package com.beadando.eloadasbeadandoui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Feladat1aController {

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

    private void loadTableData() {
        List<RendelesExpanded> rendelesList = DbManager.getRendelesekExpandedAll();
        ObservableList<RendelesExpanded> observableList = FXCollections.observableArrayList(rendelesList);

        rendelesTable.setItems(observableList);
    }

    @FXML
    protected void onBackToMenuClick() throws IOException {
        try {
            BeadandoUIApplication.switchScene("main-menu.fxml", "Főmenü");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
