package com.codecool;

import javafx.print.PrinterAttributes;

public class Furniture extends Items {
    protected String[] materials;
    protected String effect;

    public Furniture(String name, String effect, String[] materials) {
        super(name);
        this.materials = materials;
        this.effect = effect;
    }

    public String[] getMaterials() {
        return materials;
    }

    public int getMaterialslenght() {
        return materials.length;
    }
    public String getEffect(){
        return effect;
    }

    public void printAttributes() {
        System.out.println(getName()+"\t"+getEffect());
        for (String material : materials) {
            System.out.println("\t " + material);
        }
        System.out.println("=========\n");
    }
}