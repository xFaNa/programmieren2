package zoo.animal;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoMain {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Zoo.class.getName());

        // Log-Level einstellen
        logger.setLevel(Level.FINE);

        ConsoleHandler handler = new ConsoleHandler();

        handler.setLevel((Level.FINE));

        logger.addHandler(handler);

        logger.setUseParentHandlers(false);

        Zoo zoo = new Zoo();

        Aquarium<Fish> aquarium = new Aquarium<>("Aquarium");
        aquarium.add(new Trout("Nemo"));
        aquarium.add(new Salmon("Lachs"));

        MammalHouse<Lion> mammalHouse = new MammalHouse<>("Großkatzenhaus");
        mammalHouse.add(new Lion("Simba"));
        mammalHouse.add(new Lion("Mufasa"));

        zoo.addEnclosure(aquarium);
        zoo.addEnclosure(mammalHouse);

        System.out.println(zoo.summary());

        zoo.findEnclosureByName("Aquarium");
        zoo.findEnclosureByName("Nicht Vorhanden");
    }
}