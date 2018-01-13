package com.codecool;

public class MilitaryBase extends Location {
    protected Items[] scarvangable;
    protected Creatures[] enemies;
    
    public MilitaryBase(int radiationLevel, Items[] scarvangable, Creatures[] enemies){
        super(radiationLevel);
        this.scarvangable = scarvangable;
        this.enemies = enemies;
    }
}