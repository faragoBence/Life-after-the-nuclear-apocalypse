package com.codecool;

import java.util.Random;

public class GasStation extends Location {
    protected Items[] scarvangable;
    protected Creatures[] enemies;

    public GasStation(int radiationLevel, Items[] lootable, Creatures[] enemies, int[] enemyPercent, int[] lootPercent) {
        super(radiationLevel, lootable, enemies, enemyPercent, lootPercent);
    }

    static Items[] createLootableList() {
        Items[] items = new Items[9];
        items[0] = new Medicine("stimpak", 50, 50);
        items[1] = new Medicine("vodka", 20, 35);
        items[2] = new Medicine("radaway", 10, 30);
        items[3] = new Food("canned food", 35, 0);
        items[4] = new Food("nuka cola", 40, -5);
        items[5] = new Food("fresh water", 25, -5);
        items[6] = new Food("corn", 15, -5);
        items[7] = new Weapon("knife", 10, 3);
        items[8] = new Weapon("baseball bat", 15, 3);

        return items;

    }

    static public Creatures[] createCreaturesList() {
        Creatures[] creatures = new Creatures[5];
        creatures[0] = new Creatures("ghoul", 25, 5);
        creatures[1] = new Creatures("bandit", 25, 7);
        creatures[2] = new Creatures("scarvanger", 20, 5);
        creatures[3] = new Creatures("super human", 50, 5);
        creatures[4] = new Creatures("infested bear", 50, 10);

        return creatures;
    }

    static public int[] createEnemyPercentList(){
        return new int[]{26,51,71,91,101};
    }
    static public int[] createLootPercentList(){
        return new int[]{11,21,31,51,66,81,91,96,101};
    }

    static GasStation createGasStation() {
        return new GasStation(10, createLootableList(), createCreaturesList(), createEnemyPercentList(), createLootPercentList());
    }
}