import java.io.Serializable;

public class FootballPlayer implements Serializable {
    private String name;
    private int age;
    private String team;
    private double salary;

    public FootballPlayer(String name, int age, String team, double salary) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.team + " " + this.salary;
    }
}
