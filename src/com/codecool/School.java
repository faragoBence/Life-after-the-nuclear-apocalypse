package com.codecool;

import java.util.Random;

public class School extends Location {

    public School(int radiationLevel, Items[] lootable, Creatures[] enemies, int[] enemyPercent, int[] lootPercent) {
        super(radiationLevel, lootable, enemies, enemyPercent, lootPercent);
    }

    static Items[] createLootableList() {
        Items[] items = new Items[8];
        items[0] = new Medicine("first aid kit", 80, 50);
        items[1] = new Medicine("rad-x", 25, 60);
        items[2] = new Food("apple", 10, -2);
        items[3] = new Food("corn", 15, -5);
        items[4] = new Food("langos", 25, -10);
        items[5] = new Food("chili", 50, -20);
        items[6] = new Weapon("knife", 10, 3);
        items[7] = new Weapon("chainsaw", 20, 5);

        return items;

    }

    static public Creatures[] createCreaturesList() {
        Creatures[] creatures = new Creatures[5];
        creatures[0]= new Creatures("ghoul", 25, 5);
        creatures[1] = new Creatures("bandit", 25, 7);
        creatures[2] = new Creatures("scarvanger", 20, 5);
        creatures[3] = new Creatures("infested hound", 30, 10);
        creatures[4] = new Creatures("zombie", 20, 7);

        return creatures;
    }

    static public int[] createEnemyPercentList(){
        return new int[]{26,46,61,81,101};
    }
    static public int[] createLootPercentList(){
        return new int[]{16,26,41,56,76,86,96,101};
    }

    static School createSchool() {
        return new School(5, createLootableList(), createCreaturesList(),createEnemyPercentList(),createLootPercentList());
    }
}