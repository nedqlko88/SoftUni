package p08_military_elit.impl;

import p08_military_elit.contracts.Private;

public class PrivateBase extends BaseSoldier implements Private {
    private double salary;

    public PrivateBase(String id, String firstName, String laststName, double salary) {
        super(id, firstName, laststName);
        this.salary = salary;

    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f", super.toString(), this.salary);
    }
}
