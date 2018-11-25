package p08_military_elit.impl;

import p08_military_elit.contracts.Spy;

public class SpyBase extends BaseSoldier implements Spy {

    private String codeNumber;

    public SpyBase(String id, String firstName, String laststName, String codeNumber) {
        super(id, firstName, laststName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder spy = new StringBuilder(super.toString()).append(System.lineSeparator())
                .append(String.format("Code Number: %s", this.codeNumber));
        return spy.toString();
    }
}
