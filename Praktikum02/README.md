# Blatt 02 : Git Branches, JUnit Basics; CI-Pipeline

## Aufgabe: Git-Spiel
### Experiment 1:
Ich habe auf master die Datei hero.md geändert, die im Branch end nicht verändert wurde. Danach habe ich origin/end in master gemergt. Git konnte den Merge automatisch durchführen. Es entstand ein Merge-Commit. Ein Konflikt trat nicht auf, weil die Änderungen unterschiedliche Dateien betrafen.

### Experiment 2:
Ich habe auf dem master branch die Datei questlog.md an einer anderen Stelle wie auf dem branch end geändert. Beim Merge konnte Git die Änderungen automatisch zusammenführen. Es entstand kein Konflikt, weil sich die änderungen nicht auf dieselben Zeilen bezogen.

### Experiment 3:
Wenn im master Branch dieselbe Stelle wie im Branch end verändert wird und die Änderung exakt identisch ist, kann Git die Änderung automatisch zusammenführen und es entsteht kein Merge-Konflikt.

Sind die Änderungen an derselben Stelle jedoch unterschiedlich, selbst wenn sie nur minimal anders sind, kann Git nicht automatisch entscheiden, welche Version korrekt ist. In diesem Fall entsteht ein Merge-Konflikt, welcher nur manuell aufgelöst werden kann.

### Experiment 4:
Zuerst habe ich auf master eine Änderung in questlog.md vorgenommen und comitted. Danach wurde der Branch end ausgecheckt und master in end gemergt. Dadurch enthielt end nun sowohl seine ursprüngliche Änderungen als auch die Änderungen aus master.
Als anscchließend wieder zurück auf master gewechselt und end in master gemergt wurde, entstand kein weiterer Merge-Konflikt. Git konnte eien Fast-Forward durchführen, weil end bereits auf master aufbaute und zusätzlich die änderung aus end enthielt. Der master Branch wurde dadurch einfach auf den neueren Stand von end weitergesetzt. 

## Cat-Cafe
### Google-Java-Format
Das Standardformat von google-java-format verwendet fest eine Einrückung von 2 Leerzeichen und lässt sich nicht direkt konfigurieren. Alternativ kann jedoch der im Formatter enthaltene AOSP-Stil (Android Open Source Project) verwendet werden, der eine Einrückung von 4 Leerzeichen nutzt. Dabei handelt es sich jedoch nicht um eine Anpassung des Google-Stils, sondern um die Verwendung eines anderen vordefinierten Formatierungsstils.

### JUnit Testfälle 
Die Testfälle sind relevant, da sie das Verhalten der Klasse CatCafe in unterschiedlichen Situationen überprüfen. Dabei werden nicht nur einfache Standardfälle getestet, sondern auch Randfälle und Fehlerfälle berücksichtigt.

Für die Methode getCatCount werden drei grundlegende Fälle geprüft: ein leeres Café (0 Katzen), ein Café mit genau einer Katze sowie ein Café mit mehreren Katzen. Dadurch wird sichergestellt, dass die Zählung unabhängig von der Anzahl korrekt funktioniert.

Die Methode addCat wird insbesondere im Hinblick auf Fehlerfälle getestet. Hier wird überprüft, dass beim Hinzufügen von null eine NullPointerException ausgelöst wird, da dies im Code explizit vorgesehen ist.

Für getCatByName werden verschiedene Suchszenarien betrachtet. Es wird geprüft, ob eine vorhandene Katze korrekt gefunden wird, ob bei einem nicht existierenden Namen null zurückgegeben wird und wie sich die Methode bei einer null-Eingabe verhält. Damit werden sowohl erfolgreiche als auch fehlgeschlagene Suchanfragen abgedeckt.

Die Methode getCatByWeight wird besonders gründlich getestet, da sie mehrere Bedingungen enthält. Es wird überprüft, ob eine Katze innerhalb eines gültigen Gewichtsbereichs gefunden wird, ob die untere Grenze (inklusive) korrekt funktioniert und ob die obere Grenze (exklusive) eingehalten wird. Zusätzlich werden ungültige Eingaben wie negative Gewichte oder ein Maximalwert kleiner als der Minimalwert getestet, bei denen die Methode null zurückgeben soll.

Die Testfälle sind somit unterschiedlich, da sie verschiedene Methoden, verschiedene Arten von Eingaben sowie unterschiedliche Programmzustände abdecken. Dadurch wird nicht nur überprüft, ob das Programm im Normalfall funktioniert, sondern auch, ob es in Rand- und Fehlerfällen korrekt reagiert.