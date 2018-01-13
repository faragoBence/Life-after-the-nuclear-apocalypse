package com.codecool;

public class Weapon extends Items{
    protected int strength;
    protected int durability;


    public Weapon(String name, int strength, int durability){
        super(name);
        this.strength = strength;
        this.durability = durability;
    }

    public String getName(){
        return name;
    }
    public int getStrength(){
        return strength;
    }
    public void setStrength(int value){
        strength += value;
    }
    public int getDurabillity(){
        return durability;
    }
    public void setDurabillity(int value){
        durability += value;
    }
}
    