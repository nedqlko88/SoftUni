package p08_military_elit.impl;

import p08_military_elit.contracts.Commando;
import p08_military_elit.contracts.Mission;

import java.util.Set;

public class CommandoBase extends SpecialisedBaseSoldier implements Commando {
    private Set<Mission> missions;

    public CommandoBase(String id, String firstName, String laststName, double salary, String corps, Set<Mission> missions) {
        super(id, firstName, laststName, salary, corps);
        this.missions = missions;
    }

    @Override
    public String toString() {
        StringBuilder commando = new StringBuilder(super.toString()).append(System.lineSeparator());

        commando
                .append("Missions:");

        for (Mission mission : this.missions) {
            commando
                    .append(System.lineSeparator())
                    .append("  ")
                    .append(mission);
        }
        return commando.toString();
    }
}
