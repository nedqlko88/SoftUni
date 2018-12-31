package hell.entities.miscellaneous;

import hell.entities.items.CommonItem;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HeroInventoryTest {

    private static final int VALUE = Integer.MAX_VALUE;
    private static final long EXPECTED_OUTPUT = 3L * Integer.MAX_VALUE;
    private static final String STRENGTH_MESSAGE = "Strength is not correct!";
    private static final String AGILITY_MESSAGE = "Agility is not correct!";
    private static final String HIT_POINTS_MESSAGE = "HitPoints is not correct!";
    private static final String DAMAGE_MESSAGE = "Damage is not correct!";
    private static final String INTELLIGENCE_MESSAGE = "Intelligence is not correct!";

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        this.inventory = new HeroInventory();
        this.seedCommonItems();
    }

    private Item createCommonItemMock() {
        Item commonItem = Mockito.mock(Item.class);
        Mockito.when(commonItem.getName()).thenReturn(String.valueOf(Math.random()));
        Mockito.when(commonItem.getStrengthBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getAgilityBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getDamageBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getHitPointsBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getIntelligenceBonus()).thenReturn(VALUE);

        return commonItem;
    }

    private void seedCommonItems() {
        this.inventory.addCommonItem(this.createCommonItemMock());
        this.inventory.addCommonItem(this.createCommonItemMock());
        this.inventory.addCommonItem(this.createCommonItemMock());

    }

    @Test
    void getTotalStrengthBonus() {
        //Arrange - vkarali sme go gore v BEFORE-a

        //Act
        long actualTotalStrengthBonus = this.inventory.getTotalStrengthBonus();
//        long expectedTotalStrengthBonus = 3L * VALUE; // otlqvo imame long  a otdqsno pone ednoto trqbva da e Long

        //Assert
    Assert.assertEquals(STRENGTH_MESSAGE, EXPECTED_OUTPUT, actualTotalStrengthBonus);
    }

    @Test
    void getTotalAgilityBonus() {
        long actualTotalAgilityBonus = this.inventory.getTotalAgilityBonus();
        Assert.assertEquals(AGILITY_MESSAGE, EXPECTED_OUTPUT, actualTotalAgilityBonus);
    }

    @Test
    void getTotalIntelligenceBonus() {
        long actualTotalIntelligenceBonus = this.inventory.getTotalIntelligenceBonus();
        Assert.assertEquals(INTELLIGENCE_MESSAGE, EXPECTED_OUTPUT, actualTotalIntelligenceBonus);
    }

    @Test
    void getTotalHitPointsBonus() {
        long actualTotalHitPointsBonus = this.inventory.getTotalHitPointsBonus();
        Assert.assertEquals(HIT_POINTS_MESSAGE, EXPECTED_OUTPUT, actualTotalHitPointsBonus);
    }

    @Test
    void getTotalDamageBonus() {
        long actualTotalDamageBonus = this.inventory.getTotalDamageBonus();
        Assert.assertEquals(DAMAGE_MESSAGE, EXPECTED_OUTPUT, actualTotalDamageBonus);
    }

    @Test
    void addCommonItem() {
    }

    @Test
    void addRecipeItem() {
    }
}