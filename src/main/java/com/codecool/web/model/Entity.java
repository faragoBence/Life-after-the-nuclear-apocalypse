package com.codecool.web.model;

import com.codecool.web.exception.PlayerIsDeadException;

public abstract class Entity {
    private final String name;
    private int health;
    private int strength;
    private int agility;

    public Entity(String name, int health, int strength, int agility) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int value) throws PlayerIsDeadException {
        health += value;
        if (this instanceof Survivor) {
            if (health < 1) {
                throw new PlayerIsDeadException();
            }
            if (health > 100) {
                health = 100;
            }
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int value) {
        strength = value;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int value) {
        agility += value;
        if (agility > 30) {
            agility = 30;
        }
    }
}
