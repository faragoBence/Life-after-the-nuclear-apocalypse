package com.codecool;

import java.util.Random;

public class School extends Location {

    public School(int radiationLevel, Items[] lootable, Creatures[] enemies, int[] enemyPercent, int[] lootPercent, String description) {
        super(radiationLevel, lootable, enemies, enemyPercent, lootPercent, description);
    }

    static Items[] createLootableList() {
        Items[] items = new Items[8];
        items[0] = new Medicine("First aid kit", 80, 50);
        items[1] = new Medicine("Rad-x", 25, 60);
        items[2] = new Food("Apple", 10, -2);
        items[3] = new Food("Corn", 15, -5);
        items[4] = new Food("Langos", 25, -10);
        items[5] = new Food("Chili", 50, -20);
        items[6] = new Weapon("Knife", 10, 3);
        items[7] = new Weapon("Chainsaw", 20, 5);

        return items;

    }

    static public Creatures[] createCreaturesList() {
        Creatures[] creatures = new Creatures[5];
        creatures[0]= new Creatures("Ghoul", 25, 5);
        creatures[1] = new Creatures("Bandit", 25, 7);
        creatures[2] = new Creatures("Scarvanger", 20, 5);
        creatures[3] = new Creatures("Infested hound", 30, 10);
        creatures[4] = new Creatures("Zombie", 20, 7);

        return creatures;
    }

    static public int[] createEnemyPercentList(){
        return new int[]{26,46,61,81,101};
    }
    static public int[] createLootPercentList(){
        return new int[]{16,26,41,56,76,86,96,101};
    }
    static public String createDescription(){
        return "The School seems very friendly, just some lightweight enemies staying here, protecting a very misc loot";
    }

    static School createSchool() {
        return new School(5, createLootableList(), createCreaturesList(),createEnemyPercentList(),createLootPercentList(),createDescription());
    }
}