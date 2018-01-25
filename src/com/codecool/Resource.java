package com.codecool;

public class Resource extends Items {
    int value;
    public Resource(String name,int value){
        super (name);
        this.value = value;

    }

    public static Resource[] createResourceList(){
        return new Resource[]{new Resource("Scrap metal",2), new Resource("Wood",1), new Resource("Chemical",2), new Resource("Food",1)};
    }

    public int getValue(){
        return value;
    }
}