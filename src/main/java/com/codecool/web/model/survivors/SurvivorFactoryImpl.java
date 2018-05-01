package com.codecool.web.model.survivors;

public class SurvivorFactoryImpl implements SurvivorFactory{

    @Override
    public Survivor createSurvivor(String name, String type) {
        Class classEnum = Class.valueOf(type);
        switch (classEnum){
            case MAGE:
                return new Survivor(name,3,3,80,80,75,100,100,3,10,"OUTPOST","Mage");
            case HUNTER:
                return new Survivor(name,2,2,100,100,80,90,90,5,8,"OUTPOST","Hunter");
            case WARRIOR:
                return new Survivor(name,2,2,80,80,100,80,80,7,5,"OUTPOST","Warrior");
            default:
                return null;
        }
    }
}
