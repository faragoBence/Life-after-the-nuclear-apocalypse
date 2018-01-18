package com.codecool;

import java.util.Random;

public class MilitaryBase extends Location {

    public MilitaryBase(int radiationLevel, Items[] lootable, Creatures[] enemies) {
        super(radiationLevel, lootable, enemies);
    }

    static Items[] createLootableList() {
        Items[] items = new Items[8];
        items[0] = new Medicine("painkiller", 30, 0);
        items[1] = new Medicine("radaway", 10, 30);
        items[2] = new Medicine("vodka", 20, 35);
        items[3] = new Food("chili", 50, -20);
        items[4] = new Food("apple", 10, -2);
        items[5] = new Weapon("shotgun", 30, 2);
        items[6] = new Weapon("handgun", 25, 2);
        items[7] = new Weapon("rocket launcher", 50, 1);

        return items;

    }

    static public Creatures[] createCreaturesList() {
        Creatures[] creatures = new Creatures[6];
        creatures[0] = new Creatures("ghoul", 25, 5);
        creatures[1] = new Creatures("bandit", 25, 7);
        creatures[2] = new Creatures("infested bear", 50, 10);
        creatures[3] = new Creatures("infested hound", 30, 10);
        creatures[4] = new Creatures("our sugardaddy : George Soros", 50, 15);
        creatures[5] = new Creatures("super human", 50, 5);

        return creatures;
    }

    static MilitaryBase createMilitaryBase() {
        return new MilitaryBase(20, createLootableList(), createCreaturesList());
    }

    public void search(Survivor survivor, Outpost outpost) {
        if (survivor.getActionPoints() > 0) {

            survivor.setRadiationLevel(getRadiationLevel());
            Random random = new Random();
            int lootPercent = random.nextInt(100) + 1;
            int enemyPercent = random.nextInt(100) + 1;
            Items loot;
            Creatures enemy;
            if (lootPercent < 6) {
                loot = lootable[0];
            } else if (lootPercent < 16) {
                loot = lootable[1];
            } else if (lootPercent < 21) {
                loot = lootable[2];
            } else if (lootPercent < 36) {
                loot = lootable[3];
            } else if (lootPercent < 46) {
                loot = lootable[4];
            } else if (lootPercent < 71) {
                loot = lootable[5];
            } else if (lootPercent < 96) {
                loot = lootable[6];
            } else {
                loot = lootable[7];
            }

            if (enemyPercent < 11) {
                enemy = enemies[0];
            } else if (enemyPercent < 21) {
                enemy = enemies[1];
            } else if (enemyPercent < 46) {
                enemy = enemies[2];
            } else if (enemyPercent < 71) {
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