package P02_FileStream;

public class StreamProgressInfo {
    private Stream source;

    // If we want to stream a music file, we can't
    public StreamProgressInfo(Stream file) {
        this.source = file;
    }

    public int calculateCurrentPercent() {
        return (this.source.getBytesSent() * 100) / this.source.getLength();
    }
}
