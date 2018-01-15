package com.codecool;

public class Medicine extends Items {
    protected int healingFactor;
    protected int radiationHealingFactor;

    public Medicine(String name, int healingFactor, int radiationHealingFactor) {
        super(name);
        this.healingFactor = healingFactor;
        this.radiationHealingFactor = radiationHealingFactor;
    }

    public int getHealingFactor() {
        return healingFactor;
    }

    public int getRadiationHealingFactor() {
        return radiationHealingFactor;
    }

}