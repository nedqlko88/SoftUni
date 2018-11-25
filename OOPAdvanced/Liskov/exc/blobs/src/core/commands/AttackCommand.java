package core.commands;

import annotations.Inject;
import factories.AttackFactory;
import factories.BehaviorFactory;
import factories.BlobFactory;
import interfaces.Attack;
import interfaces.Behavior;
import interfaces.Executable;
import interfaces.Repository;
import models.Blob;

public class AttackCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;


    @Override
    public void execute() {
        String sourceName = this.data[0];
        String targetName = this.data[1];

        Blob source = this.blobRepository.getByName(sourceName);
        Blob target = this.blobRepository.getByName(targetName);

        source.attack(target);
    }
}
