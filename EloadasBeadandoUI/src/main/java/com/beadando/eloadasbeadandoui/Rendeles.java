package com.beadando.eloadasbeadandoui;

import javafx.beans.property.*;
import java.util.Date;

public class Rendeles {
    // Original fields for database compatibility
    public int az;
    public String pizzanev;
    public int darab;
    public Date felvetel;
    public Date kiszallitas;

    // JavaFX properties for data binding
    private IntegerProperty azProperty = new SimpleIntegerProperty();
    private StringProperty pizzanevProperty = new SimpleStringProperty();
    private IntegerProperty darabProperty = new SimpleIntegerProperty();
    private ObjectProperty<Date> felvetelProperty = new SimpleObjectProperty<>();
    private ObjectProperty<Date> kiszallitasProperty = new SimpleObjectProperty<>();

    public Rendeles(int az, String pizzanev, int darab, Date felvetel, Date kiszallitas) {
        this.az = az;
        this.pizzanev = pizzanev;
        this.darab = darab;
        this.felvetel = felvetel;
        this.kiszallitas = kiszallitas;

        // Initialize properties
        this.azProperty.set(az);
        this.pizzanevProperty.set(pizzanev);
        this.darabProperty.set(darab);
        this.felvetelProperty.set(felvetel);
        this.kiszallitasProperty.set(kiszallitas);
    }

    // Getters and setters for the original fields
    public int getAz() {
        return az;
    }

    public void setAz(int az) {
        this.az = az;
        this.azProperty.set(az);
    }

    public String getPizzanev() {
        return pizzanev;
    }

    public void setPizzanev(String pizzanev) {
        this.pizzanev = pizzanev;
        this.pizzanevProperty.set(pizzanev);
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
        this.darabProperty.set(darab);
    }

    public Date getFelvetel() {
        return felvetel;
    }

    public void setFelvetel(Date felvetel) {
        this.felvetel = felvetel;
        this.felvetelProperty.set(felvetel);
    }

    public Date getKiszallitas() {
        return kiszallitas;
    }

    public void setKiszallitas(Date kiszallitas) {
        this.kiszallitas = kiszallitas;
        this.kiszallitasProperty.set(kiszallitas);
    }

    // Property getters for JavaFX data binding
    public IntegerProperty azProperty() {
        return azProperty;
    }

    public StringProperty pizzanevProperty() {
        return pizzanevProperty;
    }

    public IntegerProperty darabProperty() {
        return darabProperty;
    }

    public ObjectProperty<Date> felvetelProperty() {
        return felvetelProperty;
    }

    public ObjectProperty<Date> kiszallitasProperty() {
        return kiszallitasProperty;
    }
}
