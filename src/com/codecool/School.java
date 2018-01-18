package com.codecool;

import java.util.Random;

public class School extends Location {

    public School(int radiationLevel, Items[] lootable, Creatures[] enemies) {
        super(radiationLevel, lootable, enemies);
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

    static School createSchool() {
        return new School(5, createLootableList(), createCreaturesList());
    }

    public void listCreatures() {
        for (Creatures creature : enemies) {
            System.out.println(creature.getName());
        }
    }

    public void search(Survivor survivor, Outpost outpost) {
        if (survivor.getActionPoints() > 0) {

            survivor.setRadiationLevel(getRadiationLevel());
            Random random = new Random();
            int lootPercent = random.nextInt(100) + 1;
            int enemyPercent = random.nextInt(100) + 1;
            Items loot;
            Creatures enemy;
            if (lootPercent < 16) {
                loot = lootable[0];
            } else if (lootPercent < 26) {
                loot = lootable[1];
            } else if (lootPercent < 41) {
                loot = lootable[2];
            } else if (lootPercent < 56) {
                loot = lootable[3];
            } else if (lootPercent < 76) {
                loot = lootable[4];
            } else if (lootPercent < 86) {
                loot = lootable[5];
            } else if (lootPercent < 96) {
                loot = lootable[6];
            } else {
                loot = lootable[7];
            }

            if (enemyPercent < 26) {
                enemy = enemies[0];
            } else if (enemyPercent < 46) {
                enemy = enemies[1];
            } else if (enemyPercent < 61) {
                enemy = enemies[2];
            } else if (enemyPercent < 81) {
                enemy = enemies[3];
            } else {
                enemy = enemies[4];
            }
            if(Fight.fighting(survivor, enemy, outpost)){
                outpost.addTo(loot);
            }
        }else {
            System.out.println("\nYou don't have enough action points! You should rest at the outpost");
        }
        

    }
}