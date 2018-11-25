package rpg_tests;


import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int AXE_EXPEXTED_DURABILITY = AXE_DURABILITY - 1;


    private Dummy dummy;
    private Axe axe;

    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test()
    public void weaponAttacksLosesDurability() {

        this.axe.attack(this.dummy);

        Assert.assertEquals( "Looses durability not true", AXE_EXPEXTED_DURABILITY, this.axe.getDurabilityPoints());
    }


    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        this.axe = new Axe(AXE_ATTACK, 0);

        this.axe.attack(this.dummy);

    }

}
