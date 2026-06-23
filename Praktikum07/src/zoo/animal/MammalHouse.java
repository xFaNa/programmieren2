package zoo.animal;

public class MammalHouse<T extends Mammal> extends Enclosure<T> {

    public MammalHouse(String name) {
        super(name);
    }
}
