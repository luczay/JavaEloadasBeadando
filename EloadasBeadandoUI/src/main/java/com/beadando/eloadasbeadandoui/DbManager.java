package com.beadando.eloadasbeadandoui;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DbManager {
    private static final String URL = "jdbc:sqlite:C:\\Users\\plaur\\Downloads\\Adolf\\java alkalmazasok\\BeadandoProject\\EloadasBeadando\\adatok.db";

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createPizza(String nev, String kategorianev, boolean vegetarianus) {
        String query = "INSERT INTO pizza (nev, kategorianev, vegetarianus) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nev);
            pstmt.setString(2, kategorianev);
            pstmt.setBoolean(3, vegetarianus);

            pstmt.executeUpdate();
        } catch (SQLException sqlException) {
        }
    }

    public static void modifyPizza(String nev, String newKategorianev, Boolean newVegetarianus) {
        StringBuilder queryBuilder = new StringBuilder("UPDATE pizza SET ");
        boolean hasCategory = newKategorianev != null;
        boolean hasVegetarian = newVegetarianus != null;

        if (hasCategory) queryBuilder.append("kategorianev = ?");
        if (hasCategory && hasVegetarian) queryBuilder.append(", ");
        if (hasVegetarian) queryBuilder.append("vegetarianus = ?");
        queryBuilder.append(" WHERE nev = ?");

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(queryBuilder.toString())) {

            int paramIndex = 1;
            if (hasCategory) pstmt.setString(paramIndex++, newKategorianev);
            if (hasVegetarian) pstmt.setBoolean(paramIndex++, newVegetarianus);
            pstmt.setString(paramIndex, nev);

            int updatedRows = pstmt.executeUpdate();
        } catch (SQLException sqlException) {

        }
    }

    public static Pizza getPizzaDetails(String pizzaNev) {
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pizza WHERE nev = ?")) {
            stmt.setString(1, pizzaNev);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pizza(
                        rs.getString("nev"),
                        rs.getString("kategorianev"),
                        rs.getBoolean("vegetarianus")
                );
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public static void deletePizza(String nev) {
        String query = "DELETE FROM pizza WHERE nev = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nev);

            int deletedRows = pstmt.executeUpdate();
        } catch (SQLException sqlException) {

        }
    }

    public static List<String> getAllPizzaNames() {
        List<String> pizzaNames = new ArrayList<>();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT nev FROM pizza")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pizzaNames.add(rs.getString("nev"));
            }
        } catch (SQLException sqlException) {
        }
        return pizzaNames;
    }

    public static List<String> getAllCategoryNames() {
        List<String> categoryNames = new ArrayList<>();
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT nev FROM kategoria")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                categoryNames.add(rs.getString("nev"));
            }
        } catch (SQLException sqlException) {
        }
        return categoryNames;
    }

    public static List<RendelesExpanded> aggregateQuery(String pizzaName, boolean vegetarianus, String category) {
        List<RendelesExpanded> results = new ArrayList<>();
        String query = "SELECT * FROM rendeles r JOIN pizza p ON r.pizzanev = p.nev JOIN kategoria k ON p.kategorianev = k.nev WHERE p.nev = ? AND p.vegetarianus = ? AND k.nev = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pizzaName);
            stmt.setBoolean(2, vegetarianus);
            stmt.setString(3, category);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RendelesExpanded expanded = new RendelesExpanded(
                        rs.getString("kategorianev"),
                        rs.getInt("ar"),
                        rs.getString("pizzanev"),
                        rs.getBoolean("vegetarianus"),
                        rs.getInt("az"),
                        rs.getInt("darab"),
                        rs.getString("felvetel"),
                        rs.getString("kiszallitas")
                );
                results.add(expanded);
            }
        } catch (SQLException sqlException) {

        }
        return results;
    }

    public static List<Rendeles> getRendelesAll() {
        List<Rendeles> rendelesek = new ArrayList<>();
        String queryRendeles = "SELECT * FROM rendeles";

        try (Connection connection = connect()) {
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(queryRendeles)) {
                while (rs.next()) {
                    int az = rs.getInt("az");
                    String pizzanev = rs.getString("pizzanev");
                    int darab = rs.getInt("darab");
                    Date felvetel = rs.getDate("felvetel");
                    Date kiszallitas = rs.getDate("kiszallitas");
                    rendelesek.add(new Rendeles(az, pizzanev, darab, felvetel, kiszallitas));
                }
            }
        } catch (SQLException sqlException)
        {

        }

        return rendelesek;
    }

    public static List<RendelesExpanded> getRendelesekExpandedAll() {
        List<RendelesExpanded> rendelesekExpanded = new ArrayList<>();
        String queryAll = """
            SELECT
                kategoria.nev AS kategoria_nev,
                kategoria.ar AS kategoria_ar,
                pizza.nev AS pizza_nev,
                pizza.vegetarianus AS pizza_vegetarianus,
                rendeles.az AS rendeles_az,
                rendeles.darab AS rendeles_darab,
                rendeles.felvetel AS rendeles_felvetel,
                rendeles.kiszallitas AS rendeles_kiszallitas
            FROM
                kategoria
            LEFT JOIN pizza ON kategoria.nev = pizza.kategorianev
            LEFT JOIN rendeles ON pizza.nev = rendeles.pizzanev;
        """;

        try (Connection connection = connect()) {
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(queryAll)) {
                while (rs.next()) {
                    String kategoriaNev = rs.getString("kategoria_nev");
                    int kategoriaAr = rs.getInt("kategoria_ar");
                    String pizzaNev = rs.getString("pizza_nev");
                    boolean vegetarianus = rs.getBoolean("pizza_vegetarianus");
                    int rendelesAz = rs.getInt("rendeles_az");
                    int darab = rs.getInt("rendeles_darab");
                    String felvetel = rs.getString("rendeles_felvetel");
                    String kiszallitas = rs.getString("rendeles_kiszallitas");

                    RendelesExpanded rendelesExpanded = new RendelesExpanded(kategoriaNev, kategoriaAr, pizzaNev, vegetarianus, rendelesAz, darab, felvetel, kiszallitas);
                    rendelesekExpanded.add(rendelesExpanded);
                }
            }
        } catch (SQLException sqlException)
        {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(),
                    "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }

        return rendelesekExpanded;
    }
}