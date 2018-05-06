package com.codecool.web.model.locations;

import com.codecool.web.model.items.*;
import com.codecool.web.model.survivors.Survivor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Outpost {
    private final int id;
    private final String name;
    private List<Item> inventory;
    private List<Furniture> furnituresList;
    private List<Item> craftables;
    private List<List<String>> recipes;
    private List<Survivor> survivors;

    public Outpost(int id, String name) {
        this.id = id;
        this.name = name;
        this.furnituresList = createFurnitureList();
        this.craftables = createCraftables();
        this.recipes = createRecipes();
    }

    private List<Furniture> createFurnitureList() {
        Furniture[] furnitures = new Furniture[9];
        furnitures[0] = new Furniture("Bed", "+1 action points", new String[]{"Wood", "Wood", "Wool", "Wool"});
        furnitures[1] = new Furniture("Refrigerator", "+1 konserv after ':rest'",
                new String[]{"Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal"});
        furnitures[2] = new Furniture("Weaponmaker set", "You can craft weapons here", new String[]{"Scrap metal",
                "Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal"});
        furnitures[3] = new Furniture("Oven", "You can craft foods here",
                new String[]{"Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal"});
        furnitures[4] = new Furniture("Chemical Set", "You can craft foods here",
                new String[]{"Scrap metal", "Scrap metal", "Scrap metal", "Chemical", "Chemical"});
        furnitures[5] = new Furniture("Pottery", "+1 apple after ':rest'", new String[]{"Wood", "Wood", "Chemical"});
        furnitures[6] = new Furniture("Gym", "+2 basic attack power",
                new String[]{"Wood", "Wood", "Wood", "Scrap metal", "Scrap metal", "Scrap metal"});
        furnitures[7] = new Furniture("Insulation", "After ':rest' the radiation damage is decreased by 15",
                new String[]{"Wood", "Wood", "Wool", "Wool", "Scrap metal", "Scrap metal"});
        furnitures[8] = new Furniture("Water Purifier", "+1 Fresh water after ':rest'",
                new String[]{"Scrap metal", "Scrap metal", "Wood", "Wood", "Chemical", "Chemical"});
        return Arrays.asList(furnitures);

    }

    private List<Item> createCraftables() {
        Item[] craftables = new Item[11];
        craftables[0] = new Weapon("Baseball bat", 15, 3);
        craftables[1] = new Weapon("Knife", 10, 3);
        craftables[2] = new Weapon("Handgun", 25, 2);
        craftables[3] = new Weapon("Shotgun", 30, 2);
        craftables[4] = new Food("Chili", 50, -20);
        craftables[5] = new Food("Langos", 25, -10);
        craftables[6] = new Food("Canned food", 35, 0);
        craftables[7] = new Medicine("First aid kit", 80, 0);
        craftables[8] = new Medicine("Rad-x", 25, 60);
        craftables[9] = new Medicine("Stimpak", 50, 50);
        craftables[10] = new Medicine("Painkiller", 30, 0);
        return Arrays.asList(craftables);
    }

    private List<List<String>> createRecipes() {
        List<List<String>> recipes = new ArrayList<>();
        recipes.add(Arrays.asList("Wood", "Wood"));
        recipes.add(Arrays.asList("Wood", "Scrap metal"));
        recipes.add(Arrays.asList("Scrap metal", "Scrap metal", "Scrap metal"));
        recipes.add(Arrays.asList("Scrap metal", "Scrap metal", "Scrap metal", "Scrap metal"));
        recipes.add(Arrays.asList("Food", "Food", "Food", "Food"));
        recipes.add(Arrays.asList("Food", "Food"));
        recipes.add(Arrays.asList("Food", "Food", "Food"));
        recipes.add(Arrays.asList("Wool", "Wool", "Chemical"));
        recipes.add(Arrays.asList("Chemical", "Chemical"));
        recipes.add(Arrays.asList("Wool", "Wool", "Chemical", "Chemical"));
        recipes.add(Arrays.asList("Wool", "Chemical"));
        return recipes;
    }

    public List<Survivor> getSurvivors() {
        return survivors;
    }


    public List<Item> getInventory() {
        return inventory;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }
}
