package com.codecool.web.model.items;

public class Medicine extends Item {
    private final int healingFactor;
    private final int radiationHealingFactor;

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

    @Override
    public String toString() {
        return "name = "+getName()+"\thealing factor = "+healingFactor+"\tradiation healing factor = "+radiationHealingFactor;
    }
}