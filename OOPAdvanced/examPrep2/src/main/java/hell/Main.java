package hell;

import hell.entities.heroes.Barbarian;
import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;

public class Main {
    public static void main(String[] args) {
        Barbarian nedqlko = new Barbarian("nedqlko", new HeroInventory());
        long agility = nedqlko.getAgility();
    }
}