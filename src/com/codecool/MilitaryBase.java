package com.codecool;

public class MilitaryBase extends Location {

    public MilitaryBase(int radiationLevel, Items[] lootable, Creatures[] enemies, int[] enemyPercent, int[] lootPercent) {
        super(radiationLevel, lootable, enemies, enemyPercent, lootPercent);
    }

    static Items[] createLootableList() {
        Items[] items = new Items[8];
        items[0] = new Medicine("Painkiller", 30, 0);
        items[1] = new Medicine("Radaway", 10, 30);
        items[2] = new Medicine("Vodka", 20, 35);
        items[3] = new Food("Chili", 50, -20);
        items[4] = new Food("Apple", 10, -2);
        items[5] = new Weapon("Shotgun", 30, 2);
        items[6] = new Weapon("Handgun", 25, 2);
        items[7] = new Weapon("Rocket launcher", 50, 1);

        return items;

    }

    static public Creatures[] createCreaturesList() {
        Creatures[] creatures = new Creatures[6];
        creatures[0] = new Creatures("Ghoul", 25, 5);
        creatures[1] = new Creatures("Bandit", 25, 7);
        creatures[2] = new Creatures("Infested bear", 50, 10);
        creatures[3] = new Creatures("Infested hound", 30, 10);
        creatures[4] = new Creatures("Our sugardaddy : George Soros", 50, 15);
        creatures[5] = new Creatures("Super human", 50, 5);

        return creatures;
    }

    static public int[] createEnemyPercentList(){
        return new int[]{11,21,46,71,76,101};
    }
    static public int[] createLootPercentList(){
        return new int[]{6,16,21,36,46,71,96,101};
    }

    static MilitaryBase createMilitaryBase() {
        return new MilitaryBase(20, createLootableList(), createCreaturesList(), createEnemyPercentList(), createLootPercentList());
    }
}