# Reflexion zu Blatt 07

## Generics

* Generics helfen dabei, falsche Tier-Gehege-Kombinationen bereits zur Compile-Zeit zu verhindern.
* Durch `Enclosure<T extends Animal>` können nur Typen verwendet werden, die von `Animal` abgeleitet sind.
* Beispiel: Ein `Aquarium<T extends Fish>` kann nur Fische aufnehmen. Dadurch ist beispielsweise `Aquarium<Trout>` erlaubt, während `Aquarium<Lion>` vom Typchecker verhindert wird.
* Auch ein `CatHouse extends Enclosure<Lion>` erlaubt ausschließlich `Lion`-Objekte.

## Logging

* Ein Logger mit verschiedenen Log-Leveln ist flexibler als Ausgaben mit `System.out.println`, da Meldungen gezielt gefiltert werden können.
* `INFO` verwende ich für normale Methodenaufrufe, beispielsweise beim Hinzufügen oder Suchen von Gehegen.
* `WARNING` verwende ich, wenn ein angefordertes Tier oder Gehege nicht gefunden wird.
* `SEVERE` würde ich für schwerwiegende Inkonsistenzen oder interne Fehler verwenden.
* Durch die verschiedenen Log-Level lassen sich normale Abläufe und Fehlerfälle besser voneinander unterscheiden.

## Streams

* Streams haben mir besonders bei der Verarbeitung aller Tiere über mehrere Gehege hinweg geholfen.
* Mit `flatMap` lassen sich alle Tiere aus den einzelnen Gehegen zu einem Stream zusammenführen.
* Mit `filter` und `map` können bestimmte Tierarten einfach ausgewählt und verarbeitet werden.
* Die Methode `countAnimalsByType` lässt sich mit `Collectors.groupingBy` übersichtlich formulieren.
* Bei längeren Verkettungen von Stream-Operationen können Streams jedoch unübersichtlich werden. In solchen Fällen sind klassische Schleifen manchmal leichter zu lesen.
