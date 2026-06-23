package zoo.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Zoo {

    // Logger für die Protokollierung aller Zoo-Aktionen
    private static final Logger LOGGER = Logger.getLogger(Zoo.class.getName());

    // Liste aller Gehege im Zoo
    private final List<Enclosure<? extends Animal>> enclosures = new ArrayList<>();

    // Fügt ein neues Gehege zum Zoo hinzu
    public void addEnclosure(Enclosure<? extends Animal> enclosure) {
        LOGGER.info("addEnclosure aufgerufen: " + enclosure.getName());

        enclosures.add(enclosure);

        LOGGER.fine("Anzahl Gehege: " + enclosures.size());
    }

    // Liefert eine Kopie aller Gehege zurück
    public List<Enclosure<? extends Animal>> getEnclosures() {
        LOGGER.info("getEnclosures aufgerufen");

        LOGGER.fine("Anzahl Gehege: " + enclosures.size());

        return new ArrayList<>(enclosures);
    }

    // Sucht ein Gehege anhand seines Namens
    public Enclosure<? extends Animal> findEnclosureByName(String name) {
        LOGGER.info("findEnclosureByName aufgerufen: " + name);

        Enclosure<? extends Animal> enclosure = enclosures.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (enclosure == null) {
            LOGGER.warning("Kein Gehege mit Namen '" + name + "' gefunden");
        } else {
            LOGGER.fine("Gehege gefunden");
        }

        return enclosure;
    }

    // Gibt alle Tiere aus allen Gehegen zurück
    public List<Animal> getAllAnimals() {
        LOGGER.info("getAllAnimals aufgerufen");

        // flatMap verbindet die Bewohner aller Gehege zu einem gemeinsamen Stream
        List<Animal> animals = enclosures.stream()
                .flatMap(e -> e.getInhabitants().stream())
                .collect(Collectors.toList());

        LOGGER.fine("Anzahl Tiere: " + animals.size());

        return animals;
    }

    // Gibt alle Säugetiere des Zoos zurück
    public List<Mammal> getAllMammals() {
        LOGGER.info("getAllMammals aufgerufen");

        List<Mammal> mammals = getAllAnimals().stream()
                .filter(Mammal.class::isInstance)
                .map(Mammal.class::cast)
                .collect(Collectors.toList());

        LOGGER.fine("Anzahl Säugetiere: " + mammals.size());

        return mammals;
    }

    // Gibt alle Tiere zurück, die ein bestimmtes Kriterium erfüllen
    public List<Animal> getAnimalsByPredicate(Predicate<Animal> predicate) {
        LOGGER.info("getAnimalsByPredicate aufgerufen");

        List<Animal> animals = getAllAnimals().stream()
                .filter(predicate)
                .collect(Collectors.toList());

        LOGGER.fine("Gefundene Tiere: " + animals.size());

        return animals;
    }

    // Zählt die Anzahl der Tiere pro konkreter Tierklasse
    public Map<Class<? extends Animal>, Long> countAnimalsByType() {
        LOGGER.info("countAnimalsByType aufgerufen");

        // groupingBy gruppiert nach Typ, counting zählt die Objekte
        Map<Class<? extends Animal>, Long> result = getAllAnimals().stream()
                .collect(Collectors.groupingBy(
                        Animal::getClass,
                        Collectors.counting()));

        LOGGER.fine("Anzahl verschiedener Tierarten: " + result.size());

        return result;
    }

    // Liefert alle Gehege, die mehr Tiere enthalten als erlaubt
    public List<Enclosure<? extends Animal>> getOvercrowdedEnclosures(int maxAnimals) {
        LOGGER.info("getOvercrowdedEnclosures aufgerufen: maxAnimals = " + maxAnimals);

        List<Enclosure<? extends Animal>> result = enclosures.stream()
                .filter(e -> e.getInhabitants().size() > maxAnimals)
                .collect(Collectors.toList());

        LOGGER.fine("Überfüllte Gehege: " + result.size());

        return result;
    }

    // Erstellt eine kurze Zusammenfassung des aktuellen Zoo-Zustands
    public String summary() {
        LOGGER.info("summary aufgerufen");

        List<Animal> animals = getAllAnimals();

        // Anzahl der verschiedenen Tiergruppen bestimmen
        long mammals = animals.stream().filter(Mammal.class::isInstance).count();
        long birds = animals.stream().filter(Bird.class::isInstance).count();
        long fish = animals.stream().filter(Fish.class::isInstance).count();

        String result = "Zoo mit " + enclosures.size()
                + " Gehegen und "
                + animals.size()
                + " Tieren: "
                + mammals + " Mammals, "
                + birds + " Birds, "
                + fish + " Fish";

        LOGGER.fine(result);

        return result;
    }
}