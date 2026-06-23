package zoo.animal;

public class Aquarium <T extends Fish> extends Eclosure<T> {

    public Aquarium(String name) {
        super(name);
    }
}
