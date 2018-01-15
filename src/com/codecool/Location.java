package com.codecool;

public class Location {
    protected int radiationLevel;
    protected Items[] lootable;
    protected Creatures[] enemies;

    public Location(int radiationLevel, Items[] lootable, Creatures[] enemies) {
        this.radiationLevel = radiationLevel;
        this.lootable = lootable;
        this.enemies = enemies;
    }

    public int getRadiationLevel() {
        return radiationLevel;
    }

}