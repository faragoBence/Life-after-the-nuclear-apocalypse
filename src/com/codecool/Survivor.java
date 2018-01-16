package com.codecool;

public class Survivor {
    protected String name;
    protected int actionPoints;
    protected int hungerLevel;
    protected int health;
    protected int radiationLevel;
    protected int strength;
    protected String currentLocation;

    public Survivor(String name, int actionPoints, int hungerLevel, int health, int radiationLevel,int strength,
            String currentLocation) {
        this.name = name;
        this.actionPoints = actionPoints;
        this.hungerLevel = hungerLevel;
        this.health = health;
        this.radiationLevel = radiationLevel;
        this.strength = strength;
        this.currentLocation = currentLocation;
    }

    public String getName() {
        return name;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int value) {
        actionPoints += value;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int value) {
        hungerLevel += value;
        if (hungerLevel<1){
            System.out.println("You are dead");
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int value) {
        health += value;
        if (health<1){
            System.out.println("You are dead");
        }
    }

    public int getRadiationLevel() {
        return radiationLevel;
    }

    public void setRadiationLevel(int value) {
        radiationLevel += value;
        if (radiationLevel<1){
            System.out.println("You are dead");
        }
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String loc) {
        currentLocation = loc;
    }
    public int getStrength(){
        return strength;
    }

}