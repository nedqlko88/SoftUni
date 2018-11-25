package p08_military_elit.impl;

import p08_military_elit.contracts.LeutenantGeneral;
import p08_military_elit.contracts.Private;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LeutenantGeneralBase extends PrivateBase implements LeutenantGeneral {
    private Set<Private> privates;

    public LeutenantGeneralBase(String id, String firstName, String laststName, double salary, Set<Private> privates) {
        super(id, firstName, laststName, salary);
        this.privates = privates;
    }

    @Override
    public String toString() {
        StringBuilder leutenantGeneral = new StringBuilder(super.toString()).append(System.lineSeparator());

        leutenantGeneral.append("Privates:");

        Set<Private> sortedPrivates = this.privates
                .stream()
                .sorted((p1, p2) -> p2.getId().compareTo(p1.getId()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (Private privateSoldier : sortedPrivates) {
            leutenantGeneral
                    .append(System.lineSeparator())
                    .append("  ")
                    .append(privateSoldier);

        }

        return leutenantGeneral.toString();
    }
}
