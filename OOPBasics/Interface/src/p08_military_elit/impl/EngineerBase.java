package p08_military_elit.impl;

import p08_military_elit.contracts.Engineer;

import p08_military_elit.contracts.Repair;

import java.util.Set;


public class EngineerBase extends SpecialisedBaseSoldier implements Engineer {
    private Set<Repair> repairs;


    public EngineerBase(String id, String firstName, String laststName, double salary, String corps, Set<Repair> repairs) {
        super(id, firstName, laststName, salary, corps);
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        StringBuilder engineer = new StringBuilder(super.toString()).append(System.lineSeparator());

        engineer
                .append("Repairs:");

        for (Repair repair : this.repairs) {
            engineer
                    .append(System.lineSeparator())
                    .append("  ")
                    .append(repair);
        }
        return engineer.toString();
    }
}
