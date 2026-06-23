package zoo.animal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Enclosure<T extends Animal> {

    private final String name;
    private final Set<T> inhabitants;

    public Enclosure(String name) {
        this.name = name;
        this.inhabitants = new HashSet<>();
    }

    public boolean add(T animal) {
        return inhabitants.add(animal);
    }

    public boolean remove(T animal) {
        return inhabitants.remove(animal);
    }

    public List<T> getInhabitants() {
        return new ArrayList<>(inhabitants);
    }

    public String getName() {
        return name;
    }
}
