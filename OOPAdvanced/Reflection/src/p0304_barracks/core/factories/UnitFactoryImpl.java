package p0304_barracks.core.factories;

import jdk.jshell.spi.ExecutionControl;
import p0304_barracks.contracts.Unit;
import p0304_barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"p0304_barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) {
        Unit unit = null;
        try {
            Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> declaredConstructor = unitClass.getDeclaredConstructor();
            unit = (Unit) declaredConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return unit;

    }
}
