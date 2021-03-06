package models.attacks;

import interfaces.Attack;
import models.Blob;

public class Blobplode implements Attack {

    @Override
    public void execute(Blob source, Blob target) {

        int sourceHealthAfterAttack = source.getHealth() - (source.getDamage() / 2);
        if (sourceHealthAfterAttack >= 1) {
            source.setHealth(sourceHealthAfterAttack);
        }
        target.setHealth(target.getHealth() - (source.getDamage() * 2));
    }
}
