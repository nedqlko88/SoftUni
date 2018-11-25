package factories;


import interfaces.Attack;
import interfaces.Behavior;
import models.Blob;
import observers.Subject;

public final class BlobFactory {


    private BlobFactory() {

    }

    public static Blob create(String name, int health, int damage, Behavior behavior, Attack attack, Subject subject, boolean flag) {

      return new Blob(name, health, damage, behavior, attack, subject, flag);
    }
}
