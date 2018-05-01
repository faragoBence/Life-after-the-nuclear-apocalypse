package com.codecool.web.model.items;

public class Furniture extends Item {
    private String[] materials;
    private String effect;

    public Furniture(String name, String effect, String[] materials) {
        super(name);
        this.materials = materials;
        this.effect = effect;
    }

    public String[] getMaterials() {
        return materials;
    }

    public int getNumberOfMaterials() {
        return materials.length;
    }

    public String getEffect(){
        return effect;
    }

    @Override
    public String toString() {
        String str = getName()+"\t"+effect;
        for (String material : materials) {
            str+= "\t " + material;
        }
        return str;
    }
}