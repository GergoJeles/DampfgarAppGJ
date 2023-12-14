package org.example;
import java.util.Map;
import java.util.HashMap;

public class TimeCalculator {
    private static final Map<String, Integer> fruitTimes = new HashMap<>();
    private static final Map<String, Integer> vegetableTimes = new HashMap<>();

    static {
        // Initialisierung der Garzeiten für verschiedene Früchte
        fruitTimes.put("Frucht1", 10); // Frucht Nummer 1 benötigt 10 Minuten
        fruitTimes.put("Frucht2", 11); // Frucht Nummer 2 benötigt 11 Minuten
        fruitTimes.put("Frucht3", 12); // Frucht Nummer 3 benötigt 12 Minuten
        fruitTimes.put("Frucht4", 13); // Frucht Nummer 4 benötigt 13 Minuten

        // Initialisierung der Garzeiten für verschiedene Gemüse
        vegetableTimes.put("Gemuese1", 20); // Gemüse Nummer 1 benötigt 20 Minuten
        vegetableTimes.put("Gemuese2", 21); // Gemüse Nummer 2 benötigt 21 Minuten
        vegetableTimes.put("Gemuese3", 22); // Gemüse Nummer 3 benötigt 22 Minuten
        vegetableTimes.put("Gemuese4", 23); // Gemüse Nummer 4 benötigt 23 Minuten
    }

    /**
     * Berechnet die benötigte Garzeit für das ausgewählte Lebensmittel.
     *
     * @param category   Die Kategorie des Lebensmittels (Obst oder Gemüse).
     * @param type       Der Typ des Lebensmittels.
     * @param isFrozen   Gibt an, ob das Lebensmittel gefroren ist.
     * @param quantity   Die Menge der Lebensmittel.
     * @return           Die benötigte Garzeit in Minuten.
     */
    public int calculateTime(String category, String type, boolean isFrozen, int quantity) {
        int baseTime = category.equals("Obst") ? fruitTimes.getOrDefault(type, 0) : vegetableTimes.getOrDefault(type, 0);
        int frozenTime = isFrozen ? (category.equals("Obst") ? 5 : 10) : 0;
        int totalTime = baseTime + frozenTime;
        if (quantity > 1) {
            int multiplier = category.equals("Obst") ? 2 : 3;
            totalTime += (quantity - 1) * multiplier;
        }
        return totalTime;
    }
}
