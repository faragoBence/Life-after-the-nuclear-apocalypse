package com.codecool.web.model.items;

public class Weapon extends Item {
    private int strength;
    private int durability;

    public Weapon(String name, int strength, int durability) {
        super(name);
        this.strength = strength;
        this.durability = durability;
    }

    public int getStrength() {
        return strength;
    }

    public int getDurabillity() {
        return durability;
    }

    public void use() {
        durability--;
    }

    @Override
    public String toString() {
        return "name = "+getName()+"\tstrength modifier = "+strength+"\tdurability = "+durability;
    }
}
