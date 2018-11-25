package P02_FileStream;

public class Video implements Stream{
    private String name;
    private int length;
    private int bytesSent;

    public Video(String name, int length, int bytesSent) {
        this.name = name;
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getBytesSent() {
        return this.bytesSent;
    }

    @Override
    public int getLength() {
        return this.length;
    }
}
