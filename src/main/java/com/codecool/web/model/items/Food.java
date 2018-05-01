package com.codecool.web.model.items;

public class Food extends Item {
    private final int foodValue;
    private final int radiation;

    public Food(String name, int foodValue, int radiation) {
        super(name);
        this.foodValue = foodValue;
        this.radiation = radiation;
    }

    public int getFoodValue() {
        return foodValue;
    }
    public int getRadiation() {
        return radiation;
    }
    @Override
    public String toString() {
        return "name = "+getName()+"\tfood value = "+foodValue+"\tradiation = "+radiation;
    }
}