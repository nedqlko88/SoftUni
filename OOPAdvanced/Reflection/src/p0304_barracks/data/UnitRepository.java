package p0304_barracks.data;

import jdk.jshell.spi.ExecutionControl;
import p0304_barracks.contracts.Repository;
import p0304_barracks.contracts.Unit;

import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {
	private static final String NO_SUCH_UNIT_EXCEPTION_MESSAGE = "No such units in repository.";

	private Map<String, Integer> amountOfUnits;

	public UnitRepository() {
		this.amountOfUnits = new TreeMap<>();
	}

	public void addUnit(Unit unit) {
		String unitType = unit.getClass().getSimpleName();
		if (!this.amountOfUnits.containsKey(unitType)) {
			this.amountOfUnits.put(unitType, 0);
		}

		int newAmount = this.amountOfUnits.get(unitType) + 1;
		this.amountOfUnits.put(unitType, newAmount);
	}

	public String getStatistics() {
		StringBuilder statBuilder = new StringBuilder();
		for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
			String formatedEntry =
					String.format("%s -> %d%n", entry.getKey(), entry.getValue());
			statBuilder.append(formatedEntry);
		}
		statBuilder.setLength(
				statBuilder.length() - System.lineSeparator().length());

		return statBuilder.toString();
	}

	public void removeUnit(String unitType) {
		if (this.amountOfUnits.containsKey(unitType)) {
            Integer countsOfUnits = this.amountOfUnits.get(unitType);
            if (countsOfUnits > 0) {
            this.amountOfUnits.put(unitType, countsOfUnits - 1);
            } else if (countsOfUnits == 0) {
                this.amountOfUnits.remove(unitType);
                throw new IllegalArgumentException(NO_SUCH_UNIT_EXCEPTION_MESSAGE);
            }
            return;
        }
		throw new IllegalArgumentException(NO_SUCH_UNIT_EXCEPTION_MESSAGE);
	}
}
