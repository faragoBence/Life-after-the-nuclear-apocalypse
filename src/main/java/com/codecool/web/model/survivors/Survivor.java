package com.codecool.web.model.survivors;

import com.codecool.web.exception.PlayerIsDeadException;
import com.codecool.web.model.Entity;

public class Survivor extends Entity {
    private int actionPoints;
    private int maxActionPoints;
    private int hungerLevel;
    private int maxHungerLevel;
    private int radiationLevel;
    private int maxRadiationLevel;
    private String currentLocation;
    private int id;
    private final String type;
    private final String fraction;

    public Survivor(String name, int actionPoints, int maxActionPoints, int hungerLevel, int maxHungerLevel, int health, int radiationLevel, int maxRadiationLevel, int strength, int agility,
                    String currentLocation, String type, String fraction) {
        super(name, health, strength, agility);
        this.actionPoints = actionPoints;
        this.maxActionPoints = maxActionPoints;
        this.hungerLevel = hungerLevel;
        this.maxHungerLevel = maxHungerLevel;
        this.radiationLevel = radiationLevel;
        this.maxRadiationLevel = maxRadiationLevel;
        this.currentLocation = currentLocation;
        this.type = type;
        this.fraction = fraction;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int value) {
        actionPoints += value;
        if (actionPoints > maxActionPoints) {
            actionPoints = maxActionPoints;
        }
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int value) throws PlayerIsDeadException {
        hungerLevel += value;
        if (hungerLevel < 1) {
            throw new PlayerIsDeadException();
        }
        if (hungerLevel > maxHungerLevel) {
            hungerLevel = maxHungerLevel;
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
        if (radiationLevel > maxRadiationLevel) {
            radiationLevel = maxRadiationLevel;
        }
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String loc) {
        currentLocation = loc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxActionPoints() {
        return maxActionPoints;
    }

    public int getMaxHungerLevel() {
        return maxHungerLevel;
    }

    public int getMaxRadiationLevel() {
        return maxRadiationLevel;
    }

    public String getFraction() {
        return fraction;
    }

    public String getType() {
        return type;
    }


}