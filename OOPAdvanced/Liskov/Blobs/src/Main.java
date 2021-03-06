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
import utility.MutateBoolean;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleInputReader();
        Writer writer = new ConsoleOutputWriter();
        Repository<Blob> blobRepository = new BlobRepository();
        Subject subject = new Subject();
        MutateBoolean mutateBoolean = new MutateBoolean(false);

        Runnable engine = new Engine(reader, writer, blobRepository, subject, mutateBoolean);

        engine.run();

    }
}
