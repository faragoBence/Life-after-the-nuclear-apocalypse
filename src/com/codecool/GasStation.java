package com.codecool;

public class GasStation extends Location {
    protected Items[] scarvangable;
    protected Creatures[] enemies;

    public GasStation(int radiationLevel, Items[] lootable, Creatures[] enemies) {
        super(radiationLevel, lootable, enemies);
    }
}