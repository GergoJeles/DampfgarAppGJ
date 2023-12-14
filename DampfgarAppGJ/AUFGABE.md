# Dampfgar-Anwendung für Babynahrung

## Lastenheft

**Lehrveranstaltung:** Software Teststrategien  
**Begutachter:** Matthias Frohner  

**Auftragnehmer:** Gergoe Jeles - 2230016011 

**Auftraggeber_1:** Alsaied Ahmad Khaldoun - 2230017021

**Auftraggeber_2:** Hatamikia Arash - 2230017003

**Ort, Datum:** Wien, 14.11.2023

### Beschreibung

Eine Java-Konsolenanwendung muss entwickelt werden, um die Zeit und andere Informationen für das Dämpfen von Obst und Gemüse in einem Dampfgargerät für Babys zu berechnen.

### Anforderungen

Die folgenden Eingaben sollen über die Konsole erfolgen:

- Welche Kategorie von Obst oder Gemüse?
  - Soll 2 Optionen zur Auswahl zwischen Obst oder Gemüse geben, zum Beispiel: a oder b
  - Jede andere Antwort führt zu einer Rückkehr zur Auswahl zwischen diesen Optionen
- Name des Obstes oder Gemüses
  - Geben Sie eine Liste von Obstsorten aus, wenn die Obst-Kategorie ausgewählt wurde (3-4 zufällige Früchte)
  - Geben Sie eine Liste von Gemüsesorten aus, wenn die Gemüse-Kategorie ausgewählt wurde (3-4 zufällige Gemüsesorten)
  - Um eine Option auszuwählen, sollten Sie den Namen der Frucht oder des Gemüses schreiben
  - Jede andere Antwort führt zu einer Rückkehr und fragt: "Name des Obstes oder Gemüses."
- Gefroren oder Frisch?
  - Soll 2 Optionen zur Auswahl zwischen den Optionen geben, zum Beispiel: a oder b
  - Um eine Option auszuwählen, sollten Sie den Namen der Frucht oder des Gemüses schreiben
  - Jede andere Antwort führt zu einer Rückkehr und fragt: "Name des Obstes oder Gemüses."
- Die Anzahl der zu dämpfenden Früchte oder Gemüsesorten:
  - Geben Sie eine ganze Zahl zwischen 1 und 5 ein
  - Für Eingaben unter 1 oder über 5 sollte "Die Menge ist ungültig" ausgegeben werden
  - Jede andere Antwort führt zu einer Rückkehr und fragt: "Die Anzahl der Früchte oder Gemüsesorten."

### Bewertung

Die Note sollte basierend auf dem folgenden Bewertungsschema berechnet werden:

#### Für Früchte:

- Frucht Nummer 1 benötigt 10 Minuten
- Frucht Nummer 2 benötigt 11 Minuten
- Frucht Nummer 3 benötigt 12 Minuten
- Frucht Nummer 4 benötigt 13 Minuten

Wenn sie gefroren ist, werden 5 Minuten mehr benötigt, und jede +1 zur Menge wird mit 2 multipliziert.

#### Für Gemüse:

- Gemüse Nummer 1 benötigt 20 Minuten
- Gemüse Nummer 2 benötigt 21 Minuten
- Gemüse Nummer 3 benötigt 22 Minuten
- Gemüse Nummer 4 benötigt 23 Minuten

Wenn es gefroren ist, werden 10 Minuten mehr benötigt, und jede +1 zur Menge wird mit 3 multipliziert.

### Beispiel

Beispiel für Früchte: 10 + (5, wenn gefroren) + (3 \* 2) = 16 Minuten für frische und 21 Minuten für gefrorene Früchte.

### Ausgabe

Nachdem die Ausgabe abgeschlossen ist, sollte Folgendes auf der Konsole ausgegeben werden:

"Benötigte Zeit + sehr niedrige/niedrige/mittlere/hohe/sehr hohe Hitze."

Beispiel:
"Gefrorener Brokkoli (Brokkoli 15 Minuten bei hoher Hitze dämpfen)"
