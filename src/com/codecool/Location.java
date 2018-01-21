package com.codecool;

import java.util.Random;

public class Location {
    protected int radiationLevel;
    protected Items[] lootable;
    protected Creatures[] enemies;
    protected int[] enemyPercent;
    protected int[] lootPercent;

    public Location(int radiationLevel, Items[] lootable, Creatures[] enemies, int[] enemyPercent, int[] lootPercent) {
        this.radiationLevel = radiationLevel;
        this.lootable = lootable;
        this.enemies = enemies;
        this.enemyPercent = enemyPercent;
        this.lootPercent = lootPercent;
    }

    public int getRadiationLevel() {
        return radiationLevel;
    }

    public Items[] getLootable() {
        return lootable;
    }

    public Creatures[] getEnemies() {
        return enemies;
    }

    public int[] getEnemyPercent() {
        return enemyPercent;
        
    }

    public int[] getLootPercent() {
        return lootPercent;
    }

    public void search(Survivor survivor, Outpost outpost) {
        if (survivor.getActionPoints() > 0) {

            survivor.setRadiationLevel(0 - getRadiationLevel());
            Random random = new Random();
            int[] lootpercents = getLootPercent();
            int[] enemypercents = getEnemyPercent();
            Items[] lootable = getLootable();
            Creatures[] enemies = getEnemies();
            int lootPercent = random.nextInt(100) + 1;
            int enemyPercent = random.nextInt(100) + 1;
            Items loot = lootable[lootable.length - 1];
            Creatures enemy = enemies[enemies.length - 1];

            for (int i = lootpercents.length-1; i > -1; i--) {
                if (lootPercent < lootpercents[i]) {
                    loot = lootable[i];
                }
            }
            for (int i = enemypercents.length-1; i > -1; i--) {
                if (enemyPercent < enemypercents[i]) {
                    enemy = enemies[i];
                }
            }
            if (Fight.fighting(survivor, enemy, outpost)) {
                outpost.addTo(loot);
            }
        } else {
            System.out.println("\nYou don't have enough action points! You should rest at the outpost");
        }
    }

}