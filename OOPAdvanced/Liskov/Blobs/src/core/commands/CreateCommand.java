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
import observers.Subject;
import utility.MutateBoolean;

public class CreateCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Subject subject;

    @Inject
    private MutateBoolean mutateBoolean;



    @Override
    public void execute() {
        String name = this.data[0];
        int health = Integer.parseInt(this.data[1]);
        int damage = Integer.parseInt(this.data[2]);
        String behaviorType = this.data[3];
        String attackType = this.data[4];

        Behavior behavior = BehaviorFactory.create(behaviorType);
        Attack attack = AttackFactory.create(attackType);


        Blob blob  = BlobFactory.create(name, health, damage, behavior, attack, this.subject, this.mutateBoolean.getFlag());

        this.blobRepository.add(blob);
    }
}
