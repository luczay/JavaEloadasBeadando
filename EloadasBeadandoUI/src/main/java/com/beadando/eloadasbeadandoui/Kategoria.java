package com.beadando.eloadasbeadandoui;

import javafx.beans.property.*;

public class Kategoria {
    // Original fields for database compatibility
    public String nev;
    public int ar;

    // JavaFX properties for data binding
    private StringProperty nevProperty = new SimpleStringProperty();
    private IntegerProperty arProperty = new SimpleIntegerProperty();

    public Kategoria(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;

        // Initialize properties
        this.nevProperty.set(nev);
        this.arProperty.set(ar);
    }

    // Getters and setters for the original fields
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
        this.nevProperty.set(nev);
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
        this.arProperty.set(ar);
    }

    // Property getters for JavaFX data binding
    public StringProperty nevProperty() {
        return nevProperty;
    }

    public IntegerProperty arProperty() {
        return arProperty;
    }
}
