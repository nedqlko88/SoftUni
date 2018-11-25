package p03_ferrari;

public class Ferrari implements Car{

    private String driver;

    public Ferrari(String driver) {
        this.setDriver(driver);
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushTheGazPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getName() {
        return this.driver;
    }
}
