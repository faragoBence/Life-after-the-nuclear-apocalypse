package com.codecool;

import java.util.Random;


public class Hospital extends Location {

    public Hospital(int radiationLevel, Items[] lootable, Creatures[] enemies, int[] enemyPercent, int[] lootPercent, String description) {
        super(radiationLevel, lootable, enemies, enemyPercent, lootPercent, description);
    }

    static Items[] createLootableList() {
        Items[] items = new Items[8];
        items[0] = new Medicine("Radaway", 10, 30);
        items[1] = new Medicine("Painkiller", 30, 0);
        items[2] = new Medicine("Vodka", 20, 35);
        items[3] = new Medicine("Stimpak", 50, 50);
        items[4] = new Food("Nuka cola", 40, -5);
        items[5] = new Medicine("First aid kit", 80, 0);
        items[6] = new Food("Fresh water", 25, -5);
        items[7] = new Weapon("Handgun", 25, 2);

        return items;

    }

    static public Creatures[] createCreaturesList() {
        Creatures[] creatures = new Creatures[6];
        creatures[0] = new Creatures("Scarvanger", 20, 5);
        creatures[1] = new Creatures("Zombie", 20, 7);
        creatures[2] = new Creatures("Ghoul", 25, 5);
        creatures[3] = new Creatures("Bandit", 25, 7);
        creatures[4] = new Creatures("Super human", 50, 5);
        creatures[5] = new Creatures("Infested hound", 30, 10);

        return creatures;
    }

    static public int[] createEnemyPercentList(){
        return new int[]{11,26,36,51,76,101};
    }
    static public int[] createLootPercentList(){
        return new int[]{16,31,46,61,71,91,96,101};
    }
    static public String createDescription(){
        return "The Hospital is abandoned by human's centuries ago.The most of the Medicine can be found here.Some infested creature and scarvangers are protecting the place";
    }
    static Hospital createHospital() {
        return new Hospital(15, createLootableList(), createCreaturesList(), createEnemyPercentList(), createLootPercentList(), createDescription());
    }
}