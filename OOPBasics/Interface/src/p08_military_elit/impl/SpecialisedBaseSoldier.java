package p08_military_elit.impl;

import p08_military_elit.contracts.SpecialisedSoldier;

public abstract class SpecialisedBaseSoldier extends PrivateBase implements SpecialisedSoldier {
    private static final String AIRFORCES = "Airforces";
    private static final String MARINES = "Marines";
    private String corps;

    protected SpecialisedBaseSoldier(String id, String firstName, String laststName, double salary, String corps) {
        super(id, firstName, laststName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if (!AIRFORCES.equals(corps) && !MARINES.equals(corps)) {
            throw new IllegalArgumentException();
        }
        this.corps = corps;

    }

    @Override
    public String toString() {
        StringBuilder specialisedSoldier = new StringBuilder(super.toString())
                .append(System.lineSeparator());

        specialisedSoldier.append(String.format("Corps: %s", this.corps));
        return specialisedSoldier.toString();
    }
}
