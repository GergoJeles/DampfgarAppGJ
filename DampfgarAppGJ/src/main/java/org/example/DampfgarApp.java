package org.example;

public class DampfgarApp {
    private UserInputHandler inputHandler;
    private TimeCalculator calculator;

    public DampfgarApp(UserInputHandler inputHandler, TimeCalculator calculator) {
        this.inputHandler = inputHandler;
        this.calculator = calculator;
    }

    /**
     * Führt die Hauptfunktionalität der Anwendung aus.
     */
    public void run() {
        // Datenabfrage vom Benutzer
        String category = inputHandler.chooseCategory(); // Kategorie (Obst oder Gemüse)
        String type = inputHandler.chooseType(category); // Typ (z.B. Apfel, Brokkoli)
        boolean isFrozen = inputHandler.isFrozen(); // Ist das Lebensmittel gefroren
        int quantity = inputHandler.chooseQuantity(); // Menge

        // Berechnung der Garzeit
        int time = calculator.calculateTime(category, type, isFrozen, quantity);

        // Bestimmung des Hitzeniveaus
        String heatLevel = determineHeatLevel(time);

        // Formatierung und Anzeige der Ausgabe
        System.out.println("Benötigte Zeit für " + type +
                (isFrozen ? " (gefroren)" : "") + ": " + time +
                " Minuten bei " + heatLevel + " Hitze.");
    }

    /**
     * Bestimmt das Hitzeniveau basierend auf der Garzeit.
     * @param time Die Garzeit in Minuten.
     * @return Das Hitzeniveau als String.
     */
    private String determineHeatLevel(int time) {
        if (time <= 10) {
            return "sehr niedriger";
        } else if (time <= 15) {
            return "niedriger";
        } else if (time <= 20) {
            return "mittlerer";
        } else if (time <= 25) {
            return "hoher";
        } else {
            return "sehr hoher";
        }
    }
}
