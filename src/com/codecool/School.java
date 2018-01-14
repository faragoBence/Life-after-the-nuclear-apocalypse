package com.codecool;
import java.util.Random;

public class School extends Location {
    protected Items[] scarvangable;
    protected Creatures[] enemies;
    
    public School(int radiationLevel, Items[] scarvangable, Creatures[] enemies){
        super(radiationLevel);
        this.scarvangable = scarvangable;
        this.enemies = enemies;
    }
}