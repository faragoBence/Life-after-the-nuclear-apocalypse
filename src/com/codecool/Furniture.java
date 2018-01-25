package com.codecool;

public class Furniture extends Items {
    protected String[] materials;

    public Furniture(String name , String[] materials){
        super(name);
        this.materials = materials;
    }

    public String[] getMaterials(){
        return materials;
    }
    public int getMaterialslenght(){
        return materials.length;
    }
}