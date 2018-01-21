package com.codecool;

import java.util.Random;


public class Hospital extends Location {

    public Hospital(int radiationLevel, Items[] lootable, Creatures[] enemies, int[] enemyPercent, int[] lootPercent) {
        super(radiationLevel, lootable, enemies, enemyPercent, lootPercent);
    }

    static Items[] createLootableList() {
        Items[] items = new Items[8];
        items[0] = new Medicine("radaway", 10, 30);
        items[1] = new Medicine("painkiller", 30, 0);
        items[2] = new Medicine("vodka", 20, 35);
        items[3] = new Medicine("stimpak", 50, 50);
        items[4] = new Food("nuka cola", 40, -5);
        items[5] = new Medicine("first aid kit", 80, 0);
        items[6] = new Food("fresh water", 25, -5);
        items[7] = new Weapon("handgun", 25, 2);

        return items;

    }

    static public Creatures[] createCreaturesList() {
        Creatures[] creatures = new Creatures[6];
        creatures[0] = new Creatures("scarvanger", 20, 5);
        creatures[1] = new Creatures("zombie", 20, 7);
        creatures[2] = new Creatures("ghoul", 25, 5);
        creatures[3] = new Creatures("bandit", 25, 7);
        creatures[4] = new Creatures("super human", 50, 5);
        creatures[5] = new Creatures("infested hound", 30, 10);

        return creatures;
    }

    static public int[] createEnemyPercentList(){
        return new int[]{11,26,36,51,76,101};
    }
    static public int[] createLootPercentList(){
        return new int[]{16,31,46,61,71,91,96,101};
    }

    static Hospital createHospital() {
        return new Hospital(15, createLootableList(), createCreaturesList(), createEnemyPercentList(), createLootPercentList());
    }
}