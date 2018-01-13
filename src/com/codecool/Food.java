package com.codecool;

public class Food extends Items{
    protected int foodValue;
    protected int radiation;

    public Food(String name, int foodValue, int radiation){
        super(name);
        this.foodValue = foodValue;
        this.radiation = radiation;
    }

    public int getFoodValue(){
        return foodValue;
    }
    public int getRadiation(){
        return radiation;
    }


}