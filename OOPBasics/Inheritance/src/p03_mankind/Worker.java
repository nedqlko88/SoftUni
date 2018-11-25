package p03_mankind;

import java.text.DecimalFormat;

public class Worker extends Human{
    private double weekSalary;
    private double workingHours;
    private double perHour;

    public Worker(String firstName, String lastName, double salary, double workingHours) {
        super(firstName, lastName);
        this.setWeekSalary(salary);
        this.setWorkingHours(workingHours);
        this.setPerHour(salary, workingHours);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    public double getPerHour() {
        return this.perHour;
    }

    private void setPerHour(double salary, double workingHours) {
        this.perHour = this.calculateSalary(salary, workingHours);
    }

    private double calculateSalary(double salary, double workingHours) {
        double result = salary / (workingHours * 7);
        return result;
    }

    public double getWeekSalary() {
        return this.weekSalary;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: " + this.getWeekSalary());
        }
        this.weekSalary = weekSalary;
    }

    public double getWorkingHours() {
        return this.workingHours;
    }

    private void setWorkingHours(double workingHours) {
        if (workingHours < 1 || workingHours > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: " + this.getWorkingHours());
        }
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        StringBuilder sb = new StringBuilder();
        sb.append("Week Salary: ").append(df.format(this.getWeekSalary()))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(df.format(this.getWorkingHours()))
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(df.format(this.getPerHour()));
        return super.toString() + sb.toString();
    }
}
