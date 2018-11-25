package p01_system_resources;

public class LocalTime implements TimeProvider {

    @Override
    public int getHour() {
        return java.time.LocalTime.now().getHour();
    }
}
