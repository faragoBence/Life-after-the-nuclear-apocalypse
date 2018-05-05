package com.codecool.web.model.items;

import java.util.ArrayList;
import java.util.List;

public class ItemFactoryImpl implements ItemFactory {
    @Override
    public Item getItem(String name) {
        switch (name) {
            case "Stimpak":
                return new Medicine("Stimpak", 50, 50);
            case "Vodka":
                return new Medicine("Vodka", 20, 35);
            case "Radaway":
                return new Medicine("Radaway", 10, 30);
            case "Painkiller":
                return new Medicine("Painkiller", 30, 0);
            case "First aid kit":
                return new Medicine("First aid kit", 80, 0);
            case "Rad-x":
                return new Medicine("Rad-X", 25, 60);
            case "Canned food":
                return new Food("Canned food", 35, 0);
            case "Nuka cola":
                return new Food("Nuka cola", 40, -5);
            case "Fresh water":
                return new Food("Fresh water", 25, -5);
            case "Corn":
                return new Food("Corn", 15, -5);
            case "Chili":
                return new Food("Chili", 50, -20);
            case "Apple":
                return new Food("Apple", 10, -2);
            case "Langos":
                return new Food("Langos", 25, -10);
            case "Knife":
                return new Weapon("Knife", 10, 3);
            case "Baseball bat":
                return new Weapon("Baseball bat", 15, 3);
            case "Handgun":
                return new Weapon("Handgun", 25, 2);
            case "Shotgun":
                return new Weapon("Shotgun", 30, 2);
            case "Rocket launcher":
                return new Weapon("Rocket launcher", 50, 1);
            case "Chainsaw":
                return new Weapon("Chainsaw", 20, 5);
            case "Scrap metal":
                return new Resource("Scrap metal");
            case "Wood":
                return new Resource("Wood");
            case "Chemical":
                new Resource("Chemical");
            case "Food":
                new Resource("Food");
            case "Wool":
                new Resource("Wool");
            default:
                return null;
        }
    }

    @Override
    public List<Resource> createResourceList() {
        List<Resource> resourceList = new ArrayList<>();
        resourceList.add((Resource) getItem("Scrap metal"));
        resourceList.add((Resource) getItem("Wood"));
        resourceList.add((Resource) getItem("Chemical"));
        resourceList.add((Resource) getItem("Food"));
        resourceList.add((Resource) getItem("Wool"));
        return resourceList;
    }

}
