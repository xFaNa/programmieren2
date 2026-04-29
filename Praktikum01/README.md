# Praktikum 01 – Git Basics

## Aufgabe: git status erklären

Wir haben zunächst den Befehl `git status` verwendet und sehen, dass wir uns auf dem Branch `b03` befinden.

Anschließend wird angezeigt, dass die Dateien `CONTRIBUTING.md` und `homework/b03.md` verändert wurden („modified“), diese Änderungen jedoch noch nicht zur Staging Area hinzugefügt wurden („not staged for commit“).

Darüber hinaus gibt es mit `foo.java` eine untracked Datei. Diese Datei ist wahrscheinlich neu erstellt und wird von Git noch nicht verwaltet.

Am Ende zeigt die Meldung „no changes added to commit“, dass sich aktuell keine Dateien in der Staging Area befinden.

## Befehlssequenz

git add foo.java

git commit -m "Add foo.java"
```markdown
Die Datei `foo.java` wird zunächst mit `git add` zur Staging Area hinzugefügt und anschließend mit `git commit` gespeichert.```