package com.codecool.web.model.locations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MilitaryBase extends Location {

    private static final MilitaryBase militaryBase = new MilitaryBase();

    private MilitaryBase(){
        militaryBase.setName("MilitaryBase");
        militaryBase.setLootable(createLootableList(createItemNameList()));
        militaryBase.setEnemies(createCreaturesList(createCreatureNameList()));
        militaryBase.setEnemyPercent(createEnemyPercentList());
        militaryBase.setLootPercent(createLootPercentList());
        militaryBase.setRadiationLevel(createRadiationLevel());
        militaryBase.setDescription(createDescription());
    }

    static Location getInstance() {
        return militaryBase;
    }

    private List<String> createItemNameList() {
        List<String> names = new ArrayList<>();
        names.add("Painkiller");
        names.add("Radaway");
        names.add("Vodka");
        names.add("Chili");
        names.add("Apple");
        names.add("Shotgun");
        names.add("Handgun");
        names.add("Rocket launcher");

        return names;

    }

    private List<String> createCreatureNameList() {
        List<String> names = new ArrayList<>();
        names.add("Ghoul");
        names.add("Bandit");
        names.add("Infested bear");
        names.add("Infested hound");
        names.add("Our sugardaddy : George Soros");
        names.add("Super human");

        return names;
    }

    private List<Integer> createEnemyPercentList() {
        Integer[] percents = new Integer[]{11, 21, 46, 71, 76, 101};
        return Arrays.asList(percents);
    }

    private List<Integer> createLootPercentList() {
        Integer[] percents = new Integer[]{6, 16, 21, 36, 46, 71, 96, 101};
        return Arrays.asList(percents);
    }

    private String createDescription() {
        return "The MilitaryBase is the most dangerous location.Very tough enemies looking for you, but the best loots are here, the weapons.";
    }

    private int createRadiationLevel() {
        return 20;
    }
}
