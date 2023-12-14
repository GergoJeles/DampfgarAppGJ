package org.example;

import java.util.Scanner;

public class UserInputHandler {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Fragt den Benutzer nach der Kategorie des zu dämpfenden Lebensmittels.
     * Erlaubte Antworten sind "a" für Obst und "b" für Gemüse.
     * @return Die ausgewählte Kategorie ("Obst" oder "Gemüse").
     */
    public String chooseCategory() {
        System.out.println("Wählen Sie eine Kategorie: a) Obst, b) Gemüse");
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("b")) {
            System.out.println("Ungültige Eingabe. Bitte wählen Sie a oder b.");
            input = scanner.nextLine();
        }
        return input.equalsIgnoreCase("a") ? "Obst" : "Gemüse";
    }

    /**
     * Fragt den Benutzer nach dem Typ des Lebensmittels, basierend auf der gewählten Kategorie.
     * @param category Die ausgewählte Kategorie.
     * @return Der Typ des Lebensmittels.
     */
    public String chooseType(String category) {
        System.out.println("Geben Sie den Typ des " + category + " ein:");
        return scanner.nextLine();  // Vereinfachte Logik für dieses Beispiel.
    }

    /**
     * Fragt den Benutzer, ob das Lebensmittel gefroren ist.
     * Erlaubte Antworten sind "ja" oder "nein".
     * @return Wahr, wenn das Lebensmittel gefroren ist, sonst falsch.
     */
    public boolean isFrozen() {
        System.out.println("Ist es gefroren? (ja/nein)");
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("ja") && !input.equalsIgnoreCase("nein")) {
            System.out.println("Ungültige Eingabe. Bitte antworten Sie mit ja oder nein.");
            input = scanner.nextLine();
        }
        return input.equalsIgnoreCase("ja");
    }

    /**
     * Fragt den Benutzer nach der Menge des zu dämpfenden Lebensmittels.
     * Erlaubt sind Zahlen zwischen 1 und 5.
     * @return Die Anzahl der Lebensmitteleinheiten.
     */
    public int chooseQuantity() {
        System.out.println("Wie viele Einheiten möchten Sie dämpfen? (1-5)");
        while (true) {
            try {
                int quantity = Integer.parseInt(scanner.nextLine());
                if (quantity >= 1 && quantity <= 5) {
                    return quantity;
                } else {
                    System.out.println("Ungültige Anzahl. Bitte geben Sie eine Zahl zwischen 1 und 5 ein.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Das ist keine gültige Zahl. Bitte geben Sie eine Zahl zwischen 1 und 5 ein.");
            }
        }
    }
}
