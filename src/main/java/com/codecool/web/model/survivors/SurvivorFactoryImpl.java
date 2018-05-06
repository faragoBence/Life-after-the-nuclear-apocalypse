package com.codecool.web.model.survivors;

public class SurvivorFactoryImpl implements SurvivorFactory{

    @Override
    public Survivor createSurvivor(String name, String type,String fraction) {
        Class classEnum = Class.valueOf(type);
        switch (classEnum){
            case GUNSLINGER:
                return new Survivor(name,3,3,80,80,75,100,100,3,10,"OUTPOST","Gunslinger",fraction);
            case SOLDIER:
                return new Survivor(name,2,2,100,100,80,90,90,5,8,"OUTPOST","Soldier",fraction);
            case BRUISER:
                return new Survivor(name,2,2,80,80,100,80,80,7,5,"OUTPOST","Bruiser",fraction);
            default:
                return null;
        }
    }
}
