package com.codecool.web.model;

import com.codecool.web.exception.PlayerIsDeadException;

public class Survivor extends Entity {
    private int actionPoints;
    private int hungerLevel;
    private int radiationLevel;
    private String currentLocation;

    public Survivor(String name, int actionPoints, int hungerLevel, int health, int radiationLevel, int strength,int agility,
            String currentLocation) {
        super(name,health,strength,agility);
        this.actionPoints = actionPoints;
        this.hungerLevel = hungerLevel;
        this.radiationLevel = radiationLevel;
        this.currentLocation = currentLocation;
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

    public void setHungerLevel(int value) throws PlayerIsDeadException {
        hungerLevel += value;
        if (hungerLevel < 1) {
            throw new PlayerIsDeadException();
        }
        if (hungerLevel > 100) { 
            hungerLevel = 100;
        }
    }

    public int getRadiationLevel() {
        return radiationLevel;
    }

    public void setRadiationLevel(int value) throws PlayerIsDeadException {
        radiationLevel += value;
        if (radiationLevel < 1) {
            throw new PlayerIsDeadException();
        }
        if (radiationLevel > 100) {
            radiationLevel = 100;
        }
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String loc) {
        currentLocation = loc;
    }

    @Override
    public String toString() {
        String str = "";
        str+="\nname = " + getName();
        str+="\naction points = " + getActionPoints();
        str+="\nhunger = " + getHungerLevel();
        str+="\nhealth = " + getHealth();
        str+="\nradiation level = " + getRadiationLevel();
        str+="\nstrength = " + getStrength();
        str+="\nagility = " + getAgility();
        str+="\ncurrent location = " + getCurrentLocation();
        return str;
    }
}