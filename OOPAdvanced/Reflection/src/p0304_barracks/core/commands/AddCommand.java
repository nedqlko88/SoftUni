package p0304_barracks.core.commands;


import p0304_barracks.annotations.Inject;
import p0304_barracks.contracts.Executable;
import p0304_barracks.contracts.Repository;
import p0304_barracks.contracts.Unit;
import p0304_barracks.contracts.UnitFactory;
import p0304_barracks.data.UnitRepository;

public class AddCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;


    @Override
    public String execute() {
        String unitType = this.data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);

        this.repository.addUnit(unitToAdd);

        return unitType + " added!";

    }
}
