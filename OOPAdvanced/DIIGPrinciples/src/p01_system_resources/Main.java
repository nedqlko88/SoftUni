package p01_system_resources;

public class Main {
    public static void main(String[] args) {
        TimeProvider time = new LocalTime();
        Writer writer = new ConsoleWriter();

        GreetingDevice clock = new GreetingClock(time, writer);
        clock.greeting();

    }
}
