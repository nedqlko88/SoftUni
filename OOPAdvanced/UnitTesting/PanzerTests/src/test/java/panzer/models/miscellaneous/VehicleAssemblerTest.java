package panzer.models.miscellaneous;


import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class VehicleAssemblerTest {

    private Assembler vehicleAssembler;

    private AttackModifyingPart attackModifyingPart;

    private DefenseModifyingPart defenseModifyingPart;

    private HitPointsModifyingPart hitPointsModifyingPart;

    @Before
    public void setUp() throws Exception {
        //We initialize the class we test with new;
        this.vehicleAssembler = new VehicleAssembler();
//we create empty dummy fake object that we needs;
       this.attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
       this.defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
       this.hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);

       this.vehicleAssembler.addArsenalPart(this.attackModifyingPart);
       this.vehicleAssembler.addShellPart(this.defenseModifyingPart);
       this.vehicleAssembler.addEndurancePart(this.hitPointsModifyingPart);
    }

    @Test
    public void getTotalWeight() {
        //Arrange
        Mockito.when(attackModifyingPart.getWeight()).thenReturn(10.0);
        Mockito.when(defenseModifyingPart.getWeight()).thenReturn(20.0);
        Mockito.when(hitPointsModifyingPart.getWeight()).thenReturn(30.0);

        double actualTotalWeight = this.vehicleAssembler.getTotalWeight();
        double expectedTotalWeight = 60;

        Assert.assertEquals(expectedTotalWeight, actualTotalWeight, 0.1);
    }
    //Arrange

    @Test
    public void getTotalPrice() {
        //Arrange
        Mockito.when(attackModifyingPart.getPrice()).thenReturn(BigDecimal.ZERO);
        Mockito.when(defenseModifyingPart.getPrice()).thenReturn(BigDecimal.ONE);
        Mockito.when(hitPointsModifyingPart.getPrice()).thenReturn(BigDecimal.TEN);

        //Act
        BigDecimal actualTotalPrice = this.vehicleAssembler.getTotalPrice();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(11);

        //Assert
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);

    }
        Iterator<String>
//    public void getTotalPriceWithout() {
//
//        //Act
//        BigDecimal actualTotalPrice = this.vehicleAssembler.getTotalPrice();
//        BigDecimal expectedTotalPrice = BigDecimal.ZERO;
//
//        //Assert
//        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
//
//    }

    @Test
    public void getTotalAttackModification() {
        //Arrange
        Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(50);
        AttackModifyingPart attackModifyingPart1 = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(attackModifyingPart1.getAttackModifier()).thenReturn(120);
        vehicleAssembler.addArsenalPart(attackModifyingPart1);
        //Act
        long actualTotalAttackModification = vehicleAssembler.getTotalAttackModification();
        long expectedTotalAttackModification = 170;
        //Assert
        Assert.assertEquals(expectedTotalAttackModification, actualTotalAttackModification);
    }

    @Test
    public void getTotalDefenseModification() {
        //Arrange
        Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(20);
        DefenseModifyingPart defenseModifyingPart1 = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(defenseModifyingPart1.getDefenseModifier()).thenReturn(100);
        vehicleAssembler.addShellPart(defenseModifyingPart1);
        //Act
        long actualTotalDefenseModification = vehicleAssembler.getTotalDefenseModification();
        long expectedTotalDefenseModification = 120;
        //Assert
        Assert.assertEquals(expectedTotalDefenseModification, actualTotalDefenseModification);
    }

    @Test
    public void getTotalHitPointModification() {
        //Arrange
        Mockito.when(hitPointsModifyingPart.getHitPointsModifier()).thenReturn(10);
        HitPointsModifyingPart hitPointsModifyingPart1 = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(hitPointsModifyingPart1.getHitPointsModifier()).thenReturn(80);
        vehicleAssembler.addEndurancePart(hitPointsModifyingPart1);
        //Act
        long actualTotalHitModification = vehicleAssembler.getTotalHitPointModification();
        long expectedTotalHitModification = 90;
        //Assert
        Assert.assertEquals(expectedTotalHitModification, actualTotalHitModification);
    }

    @Test
    public void addArsenalPart() {
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part3 = Mockito.mock(AttackModifyingPart.class);
        this.vehicleAssembler.addArsenalPart(part2);
        this.vehicleAssembler.addArsenalPart(part3);

        int actualSize = 0;
        int expectedSize = 3;

        try {
            Field parts = vehicleAssembler.getClass().getDeclaredField("arsenalParts");
            parts.setAccessible(true);

            List<AttackModifyingPart> list = (List<AttackModifyingPart>) parts.get(this.vehicleAssembler);
            actualSize = list.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expectedSize, actualSize);

    }

    @Test
    public void addShellPart() {
    }

    @Test
    public void addEndurancePart() {
    }
}