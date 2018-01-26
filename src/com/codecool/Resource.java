package com.codecool;

public class Resource extends Items {
    public Resource(String name){
        super (name);

    }

    public static Resource[] createResourceList(){
        return new Resource[]{new Resource("Scrap metal"), new Resource("Wood"), new Resource("Chemical"), new Resource("Food"),new Resource("Wool")};
    }
}