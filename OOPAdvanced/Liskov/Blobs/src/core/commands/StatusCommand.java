package core.commands;

import annotations.Inject;
import interfaces.Executable;
import interfaces.Repository;
import interfaces.Writer;
import models.Blob;

public class StatusCommand implements Executable {

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Writer writer;


    @Override
    public void execute() {
        this.blobRepository.findAll().forEach(blob -> this.writer.writeLine(blob.toString()));
    }
}
