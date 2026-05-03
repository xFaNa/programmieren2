# Praktikum 01 – Git Basics

## Aufgabe: Git status erklären

Wir haben zunächst den Befehl `git status` verwendet und sehen, dass wir uns auf dem Branch `b03` befinden.

Anschließend wird angezeigt, dass die Dateien `CONTRIBUTING.md` und `homework/b03.md` verändert wurden („modified“), diese Änderungen jedoch noch nicht zur Staging Area hinzugefügt wurden („not staged for commit“).

Darüber hinaus gibt es mit `foo.java` eine untracked Datei. Diese Datei ist wahrscheinlich neu erstellt und wird von Git noch nicht verwaltet.

Am Ende zeigt die Meldung „no changes added to commit“, dass sich aktuell keine Dateien in der Staging Area befinden.

## Befehlssequenz

git add foo.java

git commit -m "Add foo.java"
```markdown
Die Datei `foo.java` wird zunächst mit `git add` zur Staging Area hinzugefügt und anschließend mit `git commit` gespeichert.
```
## Aufgabe: Git-Spiel

### Was passierte am Tag 01?
Mit dem Befehl `git show 4aa8014` wird sichtbar, dass der Questlog erweitert wurde.

Der Held Markus betritt erstmals den Dungeon, ist mit einem Schwert und einer leichten Rüstung ausgestattet und trifft auf die ersten Monster.
### Wann hat der Held zum ersten Mal 4 experience Punkte?
Mit dem Befehl `git log -p -- stats.md` wurde die Historie der Datei untersucht.

Im Commit `d0e415c` Tag 01.4 besitzt der Held erstmals 4 Experience Punkte.
### Wann hat der Held zum ersten Mal 10 hunger Punkte?
Mit dem Befehl `git log -p -- stats.md` wurde die Historie der Datei analysiert.

Im Commit `78f1f49` Tag 2 wurde der Hungerwert von 4 auf 10 erhöht. In diesem Commit besitzt der Held erstmals 10 Hungerpunkte.
### Wie viele Heiltränke hat der Held insgesamt in seinem Rucksack gehabt?
Mit `git log -p -- rucksack.md` wurde die Historie des Rucksacks untersucht. Dabei taucht `1 Heiltrank` zweimal als neu hinzugefügter Inhalt auf. Zwischenzeitlich wurde ein Heiltrank wieder aus dem Rucksack entfernt.

Damit hatte der Held insgesamt 2 Heiltränke im Rucksack.
### Was hat der Held im Shop gekauft? Und wie viel Gold hat er dafür bezahlt?
Mit `git log -p -S"Gold" -- rucksack.md shopkeeper.md` wurden die Änderungen mit Bezug auf Gold untersucht.

Der Held hatte zunächst `10 Gold`. Im Shop wurden mehrere Preise genannt, entscheidend ist jedoch der spätere Zustand des Rucksacks: Aus `5 Gold` wurde `1 Heiltrank`. Daraus folgt, dass der Held einen Heiltrank gekauft und dafür 5 Gold bezahlt hat.
### Was passierte zwischen Tag 03 und Tag 04, d.h. was änderte sich zwischen diesen Commits?
Mit `git diff 2ffebcf 39568d5` wurden die Änderungen zwischen den beiden Commits analysiert.

Im Questlog wird beschrieben, dass Markus gestärkt weiterzieht. Im Rucksack verschwindet das zuvor vorhandene Gold vollständig. Gleichzeitig ändern sich die Statuswerte: Die Gesundheit steigt von 5 auf 10 und der Hunger sinkt von 10 auf 0.

Daraus lässt sich schließen, dass Markus im Shop etwas gekauft und konsumiert hat, wodurch er seine Gesundheit verbessert und seinen Hunger gestillt hat.
### Hat der Held etwas gegessen? Falls ja, was und wann?

Mit `git log -p -S"Brot" -- .` wurde nach Vorkommen von Brot gesucht.

Der Held kauft zunächst in Commit `4ff8726` (tag 03.9) ein Brot. In Commit `13834cd` (tag 03.17) isst er dieses Brot. Gleichzeitig trinkt er einen Heiltrank, wodurch Brot und Heiltrank aus dem Rucksack entfernt werden.

## Commit-Meldungen

### Commit 3e37472

Positiv:
- Struktur mit Stichpunkten vorhanden
- Themenbereich erkennbar

Negativ:
- Titel zu ungenau („better“ ist nicht aussagekräftig)
- Sprache uneinheitlich und unpräzise
- keine klare Struktur der Änderungen

Verbesserung:
- präzisere Beschreibung der Änderungen
- konsistente Sprache und klare Formulierungen

---

### Commit 46530b6

Negativ:
- Titel nicht aussagekräftig
- Inhalt beschreibt nur interne Git-Aktionen
- keine Informationen über tatsächliche Änderungen

Verbesserung:
- klare Beschreibung der funktionalen Änderungen
- keine internen Prozesse wie „rebase“ in Commit-Messages

