package models;

import interfaces.Attack;
import interfaces.Behavior;
import models.attacks.PutridFart;
import models.behaviors.Aggressive;
import observers.AbstractObserver;
import observers.Subject;

public class Blob extends AbstractObserver {

    private String name;
    private int currentHealth;
    private int damage;
    private Behavior behavior;
    private Attack attack;

    private int initialHealth;


    public Blob(String name, int health, int damage, Behavior behavior, Attack attack, Subject subject) {
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;
        subject.attach(this);

        this.initialHealth = health;
    }

    public int getHealth() {
        return this.currentHealth;
    }

    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }

        if (this.currentHealth <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
            this.behavior.trigger(this);
        }
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    public String getName() {
        return this.name;
    }

    public void attack(Blob target) {
        if (this.getHealth() == 0 || target.getHealth() == 0) {
            return;
        }
        this.attack.execute(this, target);
    }

    public void update() {
        if (this.behavior.isTriggered()) {
            this.behavior.applyRecurrentEffect(this);
        }
    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED", this.getName());
        }

        return String.format("Blob %s: %s HP, %s Damage", this.getName(), this.getHealth(), this.getDamage());
    }
}