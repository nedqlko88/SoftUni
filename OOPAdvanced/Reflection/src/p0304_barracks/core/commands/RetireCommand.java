package p0304_barracks.core.commands;


import jdk.jshell.spi.ExecutionControl;
import p0304_barracks.annotations.Inject;
import p0304_barracks.contracts.Executable;
import p0304_barracks.contracts.Repository;
import p0304_barracks.contracts.Unit;
import p0304_barracks.contracts.UnitFactory;

public class RetireCommand implements Executable {
    @Inject
    private String[] data;

    @Inject
    private Repository repository;


    @Override
    public String execute() {
        String unitType = this.data[1];

        try {
            this.repository.removeUnit(unitType);

        return unitType + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
