package com.codecool;

public class Weapon{
    protected String name;
    protected int strength;
    protected int durability;


    public Weapon(String name, int strength, int durability){
        this.name = name;
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
    