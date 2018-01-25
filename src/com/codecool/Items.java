package com.codecool;

public class Items {
    protected String name;

    public Items(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void printName(){
        System.out.println(getName()); 
    }
}