module com.beadando.eloadasbeadandoui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.beadando.eloadasbeadandoui to javafx.fxml;
    exports com.beadando.eloadasbeadandoui;
}