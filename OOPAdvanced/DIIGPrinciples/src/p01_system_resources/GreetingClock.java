package p01_system_resources;

public class GreetingClock implements GreetingDevice {

    private TimeProvider time;
    private Writer writer;

    GreetingClock(TimeProvider time, Writer writer) {
        this.time = time;
        this.writer = writer;
    }

    @Override
    public void greeting() {
        if (time.getHour() < 12) {
            writer.writeLine("Good morning...");
        } else if (time.getHour() < 18) {
            writer.writeLine("Good afternoon...");
        } else {
            writer.writeLine("Good evening...");
        }
    }
}
