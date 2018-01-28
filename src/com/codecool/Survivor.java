package com.codecool;

public class Survivor {
    private String name;
    private int actionPoints;
    private int hungerLevel;
    private int health;
    private int radiationLevel;
    private int strength;
    private String currentLocation;

    public Survivor(String name, int actionPoints, int hungerLevel, int health, int radiationLevel, int strength,
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
        if (hungerLevel < 1) {
            System.out.println("You are dead");
            System.exit(0);
        }
        if (hungerLevel > 100) { 
            hungerLevel = 100;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int value) {
        health += value;
        if (health < 1) {
            System.out.println("You are dead");
            System.exit(0);
        }
        if (health > 100) {
            health = 100;
        }
    }

    public int getRadiationLevel() {
        return radiationLevel;
    }

    public void setRadiationLevel(int value) {
        radiationLevel += value;
        if (radiationLevel < 1) {
            System.out.println("You are dead");
            System.exit(0);
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

    public int getStrength() {
        return strength;
    }
    public void setStrength(int value) {
        strength = value;
    }

    public void printAttributes() {
        System.out.println("\nname = " + getName());
        System.out.println("action points = " + getActionPoints());
        System.out.println("hunger = " + getHungerLevel());
        System.out.println("health = " + getHealth());
        System.out.println("radiation level = " + getRadiationLevel());
        System.out.println("strength = " + getStrength());
        System.out.println("current location = " + getCurrentLocation());

    }

}