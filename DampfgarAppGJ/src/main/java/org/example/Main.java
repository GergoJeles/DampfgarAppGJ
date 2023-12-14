package org.example;

public class Main {
    public static void main(String[] args) {
        DampfgarApp app = new DampfgarApp(new UserInputHandler(), new TimeCalculator());
        app.run();
    }
}
