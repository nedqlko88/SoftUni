package P02_FileStream;

public class Main {
    public static void main(String[] args) {
        Stream mp3 = new Music("DMX","Die Alone", 50,10);
        Stream file = new File("Directory", 100, 30);
        StreamProgressInfo spiMp3  = new StreamProgressInfo(mp3);
        StreamProgressInfo spiFile  = new StreamProgressInfo(file);
        StreamProgressInfo spiVideo = new StreamProgressInfo(new Video("Rocky", 300, 20));

        int infoMp3 = spiMp3.calculateCurrentPercent();
        int infoFile = spiFile.calculateCurrentPercent();
        System.out.println(infoMp3);
        System.out.println(infoFile);
        System.out.println(spiVideo.calculateCurrentPercent());
    }
}
