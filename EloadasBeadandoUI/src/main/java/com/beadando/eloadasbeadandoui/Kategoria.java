package com.beadando.eloadasbeadandoui;

import javafx.beans.property.*;

public class Kategoria {
    public String nev;
    public int ar;

    private StringProperty nevProperty = new SimpleStringProperty();
    private IntegerProperty arProperty = new SimpleIntegerProperty();

    public Kategoria(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;

        this.nevProperty.set(nev);
        this.arProperty.set(ar);
    }

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

    public StringProperty nevProperty() {
        return nevProperty;
    }

    public IntegerProperty arProperty() {
        return arProperty;
    }
}
