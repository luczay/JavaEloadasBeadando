package com.beadando.eloadasbeadandoui;

import javafx.beans.property.*;

public class RendelesExpanded {
    public String kategoriaNev;
    public int kategoriaAr;
    public String pizzaNev;
    public boolean vegetarianus;
    public int rendelesAz;
    public int darab;
    public String felvetel;
    public String kiszallitas;

    private StringProperty kategoriaNevProperty = new SimpleStringProperty();
    private IntegerProperty kategoriaArProperty = new SimpleIntegerProperty();
    private StringProperty pizzaNevProperty = new SimpleStringProperty();
    private BooleanProperty vegetarianusProperty = new SimpleBooleanProperty();
    private IntegerProperty rendelesAzProperty = new SimpleIntegerProperty();
    private IntegerProperty darabProperty = new SimpleIntegerProperty();
    private StringProperty felvetelProperty = new SimpleStringProperty();
    private StringProperty kiszallitasProperty = new SimpleStringProperty();

    public RendelesExpanded(String kategoriaNev, int kategoriaAr, String pizzaNev, boolean vegetarianus,
                            int rendelesAz, int darab, String felvetel, String kiszallitas) {
        this.kategoriaNev = kategoriaNev;
        this.kategoriaAr = kategoriaAr;
        this.pizzaNev = pizzaNev;
        this.vegetarianus = vegetarianus;
        this.rendelesAz = rendelesAz;
        this.darab = darab;
        this.felvetel = felvetel;
        this.kiszallitas = kiszallitas;

        this.kategoriaNevProperty.set(kategoriaNev);
        this.kategoriaArProperty.set(kategoriaAr);
        this.pizzaNevProperty.set(pizzaNev);
        this.vegetarianusProperty.set(vegetarianus);
        this.rendelesAzProperty.set(rendelesAz);
        this.darabProperty.set(darab);
        this.felvetelProperty.set(felvetel);
        this.kiszallitasProperty.set(kiszallitas);
    }

    public String getKategoriaNev() {
        return kategoriaNev;
    }

    public void setKategoriaNev(String kategoriaNev) {
        this.kategoriaNev = kategoriaNev;
        this.kategoriaNevProperty.set(kategoriaNev);
    }

    public StringProperty kategoriaNevProperty() {
        return kategoriaNevProperty;
    }

    public int getKategoriaAr() {
        return kategoriaAr;
    }

    public void setKategoriaAr(int kategoriaAr) {
        this.kategoriaAr = kategoriaAr;
        this.kategoriaArProperty.set(kategoriaAr);
    }

    public IntegerProperty kategoriaArProperty() {
        return kategoriaArProperty;
    }

    public String getPizzaNev() {
        return pizzaNev;
    }

    public void setPizzaNev(String pizzaNev) {
        this.pizzaNev = pizzaNev;
        this.pizzaNevProperty.set(pizzaNev);
    }

    public StringProperty pizzaNevProperty() {
        return pizzaNevProperty;
    }

    public boolean isVegetarianus() {
        return vegetarianus;
    }

    public void setVegetarianus(boolean vegetarianus) {
        this.vegetarianus = vegetarianus;
        this.vegetarianusProperty.set(vegetarianus);
    }

    public BooleanProperty vegetarianusProperty() {
        return vegetarianusProperty;
    }

    public int getRendelesAz() {
        return rendelesAz;
    }

    public void setRendelesAz(int rendelesAz) {
        this.rendelesAz = rendelesAz;
        this.rendelesAzProperty.set(rendelesAz);
    }

    public IntegerProperty rendelesAzProperty() {
        return rendelesAzProperty;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
        this.darabProperty.set(darab);
    }

    public IntegerProperty darabProperty() {
        return darabProperty;
    }

    public String getFelvetel() {
        return felvetel;
    }

    public void setFelvetel(String felvetel) {
        this.felvetel = felvetel;
        this.felvetelProperty.set(felvetel);
    }

    public StringProperty felvetelProperty() {
        return felvetelProperty;
    }

    public String getKiszallitas() {
        return kiszallitas;
    }

    public void setKiszallitas(String kiszallitas) {
        this.kiszallitas = kiszallitas;
        this.kiszallitasProperty.set(kiszallitas);
    }

    public StringProperty kiszallitasProperty() {
        return kiszallitasProperty;
    }
}
