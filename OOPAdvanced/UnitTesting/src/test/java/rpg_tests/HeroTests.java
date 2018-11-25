package rpg_tests;

import contracts.Target;
import contracts.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;
import rpg_lab.Hero;

public class HeroTests {

@Before
public void initializeTestObjects() {
    Weapon axeWeapon = Mockito.mock(Weapon.class);
    Mockito.when(axeWeapon.getAttackPoints()).thenReturn(10);
    Mockito.when(axeWeapon.getDurabilityPoints()).thenReturn(10);
    Target dummyTarget = Mockito.mock(Target.class);
    Mockito.when(dummyTarget.getHealth()).thenReturn(20);
    Hero hero = new Hero("Nedqlko", axeWeapon);
    hero.attack(dummyTarget);
}


}
