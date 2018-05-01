package com.codecool.web.model.items;

import java.util.ArrayList;
import java.util.List;

public class Resource extends Item {
    public Resource(String name){
        super (name);
    }

    public static List<Resource> createResourceList(){
        List<Resource> resourceList = new ArrayList<>();
        resourceList.add(new Resource("Scrap metal"));
        resourceList.add(new Resource("Wood"));
        resourceList.add(new Resource("Chemical"));
        resourceList.add(new Resource("Food"));
        resourceList.add(new Resource("Wool"));
        return resourceList;
    }
}