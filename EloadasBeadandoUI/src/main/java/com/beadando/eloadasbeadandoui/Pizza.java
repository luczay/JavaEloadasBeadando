package com.beadando.eloadasbeadandoui;

import javafx.beans.property.*;

public class Pizza {
    public String nev;
    public String kategorianev;
    public boolean vegetarianus;

    private StringProperty nevProperty = new SimpleStringProperty();
    private StringProperty kategorianevProperty = new SimpleStringProperty();
    private BooleanProperty vegetarianusProperty = new SimpleBooleanProperty();

    public Pizza(String nev, String kategorianev, boolean vegetarianus) {
        this.nev = nev;
        this.kategorianev = kategorianev;
        this.vegetarianus = vegetarianus;

        this.nevProperty.set(nev);
        this.kategorianevProperty.set(kategorianev);
        this.vegetarianusProperty.set(vegetarianus);
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
        this.nevProperty.set(nev);
    }

    public String getKategorianev() {
        return kategorianev;
    }

    public void setKategorianev(String kategorianev) {
        this.kategorianev = kategorianev;
        this.kategorianevProperty.set(kategorianev);
    }

    public boolean isVegetarianus() {
        return vegetarianus;
    }

    public void setVegetarianus(boolean vegetarianus) {
        this.vegetarianus = vegetarianus;
        this.vegetarianusProperty.set(vegetarianus);
    }

    public StringProperty nevProperty() {
        return nevProperty;
    }

    public StringProperty kategorianevProperty() {
        return kategorianevProperty;
    }

    public BooleanProperty vegetarianusProperty() {
        return vegetarianusProperty;
    }
}
