package com.codecool;

import java.util.Random;


public class Hospital extends Location {

    public Hospital(int radiationLevel, Items[] lootable, Creatures[] enemies) {
        super(radiationLevel, lootable, enemies);
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

    static Hospital createHospital() {
        return new Hospital(15, createLootableList(), createCreaturesList());
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
            } else if (lootPercent < 31) {
                loot = lootable[1];
            } else if (lootPercent < 46) {
                loot = lootable[2];
            } else if (lootPercent < 61) {
                loot = lootable[3];
            } else if (lootPercent < 71) {
                loot = lootable[4];
            } else if (lootPercent < 91) {
                loot = lootable[5];
            } else if (lootPercent < 96) {
                loot = lootable[6];
            } else {
                loot = lootable[7];
            }

            if (enemyPercent < 11) {
                enemy = enemies[0];
            } else if (enemyPercent < 26) {
                enemy = enemies[1];
            } else if (enemyPercent < 36) {
                enemy = enemies[2];
            } else if (enemyPercent < 51) {
                enemy = enemies[3];
            } else if (enemyPercent < 76) {
                enemy = enemies[4];
            } else {
                enemy = enemies[5];
            }
            if (Fight.fighting(survivor, enemy, outpost)) {
                outpost.addTo(loot);
            }
        } else {
            System.out.println("\nYou don't have enough action points! You should rest at the outpost");
        }

    }
}