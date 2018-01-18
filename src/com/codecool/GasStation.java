package com.codecool;

import java.util.Random;

public class GasStation extends Location {
    protected Items[] scarvangable;
    protected Creatures[] enemies;

    public GasStation(int radiationLevel, Items[] lootable, Creatures[] enemies) {
        super(radiationLevel, lootable, enemies);
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

    static GasStation createGasStation() {
        return new GasStation(10, createLootableList(), createCreaturesList());
    }

    public void search(Survivor survivor, Outpost outpost) {
        if (survivor.getActionPoints() > 0) {

            survivor.setRadiationLevel(getRadiationLevel());
            Random random = new Random();
            int lootPercent = random.nextInt(100) + 1;
            int enemyPercent = random.nextInt(100) + 1;
            Items loot;
            Creatures enemy;
            if (lootPercent < 11) {
                loot = lootable[0];
            } else if (lootPercent < 21) {
                loot = lootable[1];
            } else if (lootPercent < 31) {
                loot = lootable[2];
            } else if (lootPercent < 51) {
                loot = lootable[3];
            } else if (lootPercent < 66) {
                loot = lootable[4];
            } else if (lootPercent < 81) {
                loot = lootable[5];
            } else if (lootPercent < 91) {
                loot = lootable[6];
            } else if (lootPercent < 96) {
                loot = lootable[7];
            } else {
                loot = lootable[8];
            }

            if (enemyPercent < 26) {
                enemy = enemies[0];
            } else if (enemyPercent < 51) {
                enemy = enemies[1];
            } else if (enemyPercent < 71) {
                enemy = enemies[2];
            } else if (enemyPercent < 91) {
                enemy = enemies[3];
            } else {
                enemy = enemies[4];
            }
            if (Fight.fighting(survivor, enemy, outpost)) {
                outpost.addTo(loot);
            }
        } else {
            System.out.println("\nYou don't have enough action points! You should rest at the outpost");
        }

    }
}