import core.Engine;
import interfaces.Reader;
import interfaces.Repository;
import interfaces.Runnable;
import interfaces.Writer;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;
import models.Blob;
import observers.Subject;
import repositories.BlobRepository;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleInputReader();
        Writer writer = new ConsoleOutputWriter();
        Repository<Blob> blobRepository = new BlobRepository();
        Subject subject = new Subject();


        Runnable engine = new Engine(reader, writer, blobRepository, subject);

        engine.run();

    }
}
