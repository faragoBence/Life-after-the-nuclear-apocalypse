package com.codecool;

import java.util.Random;

public class GasStation extends Location {

    public GasStation(int radiationLevel, Items[] lootable, Creatures[] enemies, int[] enemyPercent, int[] lootPercent, String description) {
        super(radiationLevel, lootable, enemies, enemyPercent, lootPercent, description);
    }

    static Items[] createLootableList() {
        Items[] items = new Items[9];
        items[0] = new Medicine("Stimpak", 50, 50);
        items[1] = new Medicine("Vodka", 20, 35);
        items[2] = new Medicine("Radaway", 10, 30);
        items[3] = new Food("Canned food", 35, 0);
        items[4] = new Food("Nuka cola", 40, -5);
        items[5] = new Food("Fresh water", 25, -5);
        items[6] = new Food("Corn", 15, -5);
        items[7] = new Weapon("Knife", 10, 3);
        items[8] = new Weapon("Baseball bat", 15, 3);

        return items;

    }

    static public Creatures[] createCreaturesList() {
        Creatures[] creatures = new Creatures[5];
        creatures[0] = new Creatures("Ghoul", 25, 5);
        creatures[1] = new Creatures("Bandit", 25, 7);
        creatures[2] = new Creatures("Scarvanger", 20, 5);
        creatures[3] = new Creatures("Super human", 50, 5);
        creatures[4] = new Creatures("Infested bear", 50, 10);

        return creatures;
    }

    static public int[] createEnemyPercentList(){
        return new int[]{26,51,71,91,101};
    }
    static public int[] createLootPercentList(){
        return new int[]{11,21,31,51,66,81,91,96,101};
    }

    static public String createDescription(){
        return "It looks like the GasStation is almost empty, but the most of the food are leaved here.Also it is occupied by bandit's and scarvangers.";
    }

    static GasStation createGasStation() {
        return new GasStation(10, createLootableList(), createCreaturesList(), createEnemyPercentList(), createLootPercentList(),createDescription());
    }
}