package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;


    private Dummy dummy;
    private Axe axe;

    @Before
    public void initializeTestObjects() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }


    @Test
    public void dummyLosesHealthIfAttacked(){

       this.axe.attack(this.dummy);

        Assert.assertEquals("Wrong loosed health",0, this.dummy.getHealth());
    }


    @Test(expected = IllegalStateException.class)
    public void deadDummyCantBeAttacked() {

        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);

    }

    @Test
    public void deadDummyCanGiveXp() {

        this.axe.attack(this.dummy);

        Assert.assertEquals(DUMMY_EXPERIENCE , dummy.giveExperience());
    }


    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNotGiveXp() {

        this.dummy.giveExperience();
    }





}
