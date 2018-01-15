package com.codecool;

public class Creatures {
    protected String name;
    protected int health;
    protected int strength;

    public Creatures(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int value) {
        health += value;
    }

    public int getStrength() {
        return strength;
    }
}
