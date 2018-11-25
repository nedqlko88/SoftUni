package p0304_barracks.core.commands;


import p0304_barracks.contracts.Executable;
import p0304_barracks.contracts.Repository;
import p0304_barracks.contracts.Unit;
import p0304_barracks.contracts.UnitFactory;
import p0304_barracks.data.UnitRepository;

public class FightCommand implements Executable {



    @Override
    public String execute() {
        return "fight";

    }
}
