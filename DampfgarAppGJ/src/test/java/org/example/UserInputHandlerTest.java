package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UserInputHandlerTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void bereitstellenInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    // Test für die Kategorieauswahl mit gültiger Eingabe. Erwartet wird die Auswahl "Obst".
    @Test
    public void testKategorieWaehlenMitGueltigerEingabe() {
        bereitstellenInput("Obst\n");
        UserInputHandler handler = new UserInputHandler();
        assertEquals("Obst", handler.chooseCategory());
    }

    // Test für die Kategorieauswahl mit mehreren ungültigen Eingaben, gefolgt von einer gültigen Eingabe. Erwartet wird die korrekte Auswahl nach ungültigen Eingaben.
    @Test
    public void testKategorieWaehlenMitMehrerenUngueltigenEingaben() {
        bereitstellenInput("ungueltig1\nungueltig2\nObst\n");
        UserInputHandler handler = new UserInputHandler();
        handler.chooseCategory();
        String output = getOutput();
        assertTrue(output.contains("Ungültige Eingabe, bitte versuchen Sie es erneut."));
        assertTrue(output.contains("Ungültige Eingabe, bitte versuchen Sie es erneut."));
        assertEquals("Obst", handler.chooseCategory());
    }

    // Test für die Verarbeitung von ganzzahligen Eingaben. Erwartet wird eine korrekte Umwandlung der Eingabe "3" in einen Integer-Wert.
    @Test
    public void testEingabeVerarbeitungFuerGanzzahligeWerte() {
        bereitstellenInput("3\n");
        UserInputHandler handler = new UserInputHandler();
        int ergebnis = handler.getIntegerInput();
        assertEquals(3, ergebnis);
    }

    // Test für die Verarbeitung einer ungültigen, dann gültigen ganzzahligen Eingabe. Erwartet wird die korrekte Umwandlung der zweiten Eingabe "4" in einen Integer-Wert.
    @Test
    public void testGanzzahligeEingabeMitUngueltigerDannGueltigerEingabe() {
        bereitstellenInput("ungueltig\n4\n");
        UserInputHandler handler = new UserInputHandler();
        int ergebnis = handler.getIntegerInput();
        assertEquals(4, ergebnis);
    }

    // Test für die Verarbeitung von Wahrheitswerten. Erwartet wird, dass die Eingabe "ja" als wahr (true) interpretiert wird.
    @Test
    public void testEingabeVerarbeitungFuerWahrheitswerte() {
        bereitstellenInput("ja\n");
        UserInputHandler handler = new UserInputHandler();
        boolean ergebnis = handler.getBooleanInput();
        assertTrue(ergebnis);
    }

}
