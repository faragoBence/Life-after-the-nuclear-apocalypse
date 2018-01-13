package com.codecool;

public class Hospital extends Location {
    protected Items[] scarvangable;
    protected Creatures[] enemies;
    
    public Hospital(int radiationLevel, Items[] scarvangable, Creatures[] enemies){
        super(radiationLevel);
        this.scarvangable = scarvangable;
        this.enemies = enemies;
    }
}