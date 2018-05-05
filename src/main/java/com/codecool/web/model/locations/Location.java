package com.codecool.web.model.locations;

import com.codecool.web.model.creatures.Creature;
import com.codecool.web.model.creatures.CreatureFactory;
import com.codecool.web.model.creatures.CreatureFactoryImpl;
import com.codecool.web.model.items.Item;
import com.codecool.web.model.items.ItemFactory;
import com.codecool.web.model.items.ItemFactoryImpl;
import com.codecool.web.model.items.Resource;

import java.util.ArrayList;
import java.util.List;

public abstract class Location {
    private final CreatureFactory creatureFactory = new CreatureFactoryImpl();
    private final ItemFactory itemFactory = new ItemFactoryImpl();
    private String name;
    private int radiationLevel;
    private List<Item> lootable;
    private List<Creature> enemies;
    private List<Integer> enemyPercent;
    private List<Integer> lootPercent;
    private String description;
    private List<Resource> resources;


    public Location() {
        resources=itemFactory.createResourceList();
    }

    public int getRadiationLevel() {
        return radiationLevel;
    }

    void setRadiationLevel(int radiationLevel) {
        this.radiationLevel = radiationLevel;
    }

    public List<Item> getLootable() {
        return lootable;
    }

    void setLootable(List<Item> lootable) {
        this.lootable = lootable;
    }

    public List<Creature> getEnemies() {
        return enemies;
    }

    void setEnemies(List<Creature> enemies) {
        this.enemies = enemies;
    }

    public List<Integer> getEnemyPercent() {
        return enemyPercent;
    }

    void setEnemyPercent(List<Integer> enemyPercent) {
        this.enemyPercent = enemyPercent;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getLootPercent() {
        return lootPercent;
    }

    void setLootPercent(List<Integer> lootPercent) {
        this.lootPercent = lootPercent;
    }

    public String getEnemyList() {
        String str = "";
        for (Creature creature : enemies) {
            str += "\n" + creature.getName();
        }
        return str;
    }

    public String getLootableList() {
        String str = "";
        for (Item loot : lootable) {
            str += "\n" + loot.getName();
        }
        return str;
    }

    @Override
    public String toString() {
        String str = "";
        str += description;
        str += "\n\tThese loots can be found here:";
        str += getLootableList();
        str += "\n\tThese enemies can be found here:";
        str += getEnemyList();
        return str;
    }

    List<Creature> createCreaturesList(List<String> creatureNames) {
        List<Creature> creatures = new ArrayList<>();
        for (String name : creatureNames) {
            creatures.add(creatureFactory.getCreature(name));
        }
        return creatures;
    }

    List<Item> createLootableList(List<String> itemNames) {
        List<Item> items = new ArrayList<>();
        for (String name : itemNames) {
            items.add(itemFactory.getItem(name));
        }
        return items;
    }
    List<Resource> getResources() {
        return resources;
    }
}