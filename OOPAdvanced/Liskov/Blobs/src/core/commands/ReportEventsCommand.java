package core.commands;

import annotations.Inject;
import interfaces.Executable;
import interfaces.Repository;
import models.Blob;
import utility.MutateBoolean;

public class ReportEventsCommand implements Executable {

    @Inject
    private MutateBoolean mutateBoolean;



    @Override
    public void execute() {
        this.mutateBoolean.setFlag(true);
    }
}
