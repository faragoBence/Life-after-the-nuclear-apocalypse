package com.codecool;

public class GasStation extends Location {
    protected Items[] scarvangable;
    protected Creatures[] enemies;
    
    public GasStation(int radiationLevel, Items[] scarvangable, Creatures[] enemies){
        super(radiationLevel);
        this.scarvangable = scarvangable;
        this.enemies = enemies;
    }
}