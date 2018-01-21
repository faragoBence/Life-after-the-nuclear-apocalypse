package com.codecool;

public class MilitaryBase extends Location {

    public MilitaryBase(int radiationLevel, Items[] lootable, Creatures[] enemies, int[] enemyPercent, int[] lootPercent) {
        super(radiationLevel, lootable, enemies, enemyPercent, lootPercent);
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