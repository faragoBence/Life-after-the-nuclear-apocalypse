package com.codecool;

public class Survivor {
    protected String name;
    protected int actionPoints;
    protected int hungerLevel;
    protected int health;
    protected int radiationLevel;
    protected String currentLocation;

    public Survivor(String name, int actionPoints, int hungerLevel, int health, int radiationLevel,
            String currentLocation) {
        this.name = name;
        this.actionPoints = actionPoints;
        this.hungerLevel = hungerLevel;
        this.health = health;
        this.radiationLevel = radiationLevel;
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
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int value) {
        health += value;
    }

    public int getRadiationLevel() {
        return radiationLevel;
    }

    public void setRadiationLevel(int value) {
        radiationLevel += value;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String loc) {
        currentLocation = loc;
    }

}