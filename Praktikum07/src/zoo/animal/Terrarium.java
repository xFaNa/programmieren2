package zoo.animal;

public class Terrarium<T extends Mammal> extends Enclosure<T> {

    public Terrarium(String name) {
        super(name);
    }
}
