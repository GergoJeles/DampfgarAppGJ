package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimeCalculatorTest {

    // Test für frisches Obst (Äpfel). Erwartet wird eine Garzeit von 10 Minuten.
    @Test
    public void testCalculateTimeForFreshFruit() {
        TimeCalculator calculator = new TimeCalculator();
        int time = calculator.calculateTime("Obst", "Apfel", false, 1);
        assertEquals(10, time);
    }

    // Test für gefrorenes Gemüse (Brokkoli) in doppelter Menge. Erwartet wird eine Garzeit von 25 Minuten.
    @Test
    public void testCalculateTimeForFrozenVegetable() {
        TimeCalculator calculator = new TimeCalculator();
        int time = calculator.calculateTime("Gemüse", "Brokkoli", true, 2);
        assertEquals(25, time);
    }

    // Test für mehrere frische Gemüse (Karotten). Erwartet wird eine Garzeit von 20 Minuten plus 2 Minuten pro zusätzlichem Stück.
    @Test
    public void testCalculateTimeForMultipleFreshVegetables() {
        TimeCalculator calculator = new TimeCalculator();
        int time = calculator.calculateTime("Gemüse", "Karotte", false, 3);
        assertEquals(20 + 3 * 2, time);
    }

    // Test für ein einzelnes gefrorenes Gemüse (Spinat). Erwartet wird eine Garzeit von 20 Minuten plus 10 Minuten für den gefrorenen Zustand.
    @Test
    public void testCalculateTimeForSingleFrozenVegetable() {
        TimeCalculator calculator = new TimeCalculator();
        int time = calculator.calculateTime("Gemüse", "Spinat", true, 1);
        assertEquals(20 + 10, time);
    }

    // Test für ein ungültiges Lebensmittel. Erwartet wird eine IllegalArgumentException.
    @Test
    public void testCalculateTimeForInvalidFoodItem() {
        TimeCalculator calculator = new TimeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateTime("Obst", "Unbekannt", false, 1);
        });
    }

    // Test für eine übermäßige Menge an Lebensmitteln. Erwartet wird eine IllegalArgumentException.
    @Test
    public void testCalculateTimeWithExcessiveQuantity() {
        TimeCalculator calculator = new TimeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateTime("Obst", "Apfel", false, 100);
        });
    }

    // Test für frisches Obst (Äpfel) mit der Menge Null. Erwartet wird eine Garzeit von 0 Minuten.
    @Test
    public void testCalculateTimeForFreshFruitWithZeroQuantity() {
        TimeCalculator calculator = new TimeCalculator();
        int time = calculator.calculateTime("Obst", "Apfel", false, 0);
        assertEquals(0, time);
    }
}
