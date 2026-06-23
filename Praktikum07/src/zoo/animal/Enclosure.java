package zoo.animal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Enclosure<T extends Animal> {

    // Eindeutiger Name des Geheges
    private final String name;

    // Menge aller Bewohner des Geheges
    // HashSet verhindert doppelte Tiere automatisch
    private final Set<T> inhabitants;

    // Erstellt ein neues Gehege mit einem Namen und einer leeren Tiermenge
    public Enclosure(String name) {
        this.name = name;
        this.inhabitants = new HashSet<>();
    }

    // Fügt ein Tier hinzu
    // Liefert true, falls das Tier erfolgreich hinzugefügt wurde
    public boolean add(T animal) {
        return inhabitants.add(animal);
    }

    // Entfernt ein Tier
    // Liefert true, falls das Tier vorhanden war
    public boolean remove(T animal) {
        return inhabitants.remove(animal);
    }

    // Gibt alle Bewohner als Liste zurück
    public List<T> getInhabitants() {
        return new ArrayList<>(inhabitants);
    }

    // Gibt den Namen des Geheges zurück
    public String getName() {
        return name;
    }
}