package com.codecool.web.model.locations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School extends Location {
    private static final School school = new School();

    private School() {
        school.setName("School");
        school.setLootable(createLootableList(createItemNameList()));
        school.setEnemies(createCreaturesList(createCreatureNameList()));
        school.setEnemyPercent(createEnemyPercentList());
        school.setLootPercent(createLootPercentList());
        school.setRadiationLevel(createRadiationLevel());
        school.setDescription(createDescription());
    }

    static Location getInstance() {
        return school;
    }

    private List<String> createItemNameList() {
        List<String> names = new ArrayList<>();
        names.add("First aid kit");
        names.add("Rad-x");
        names.add("Apple");
        names.add("Corn");
        names.add("Langos");
        names.add("Chili");
        names.add("Knife");
        names.add("Chainsaw");

        return names;

    }

    private List<String> createCreatureNameList() {
        List<String> names = new ArrayList<>();
        names.add("Ghoul");
        names.add("Bandit");
        names.add("Scarvanger");
        names.add("Infested hound");
        names.add("Zombie");

        return names;
    }

    private List<Integer> createEnemyPercentList() {
        Integer[] percents = new Integer[]{26, 46, 61, 81, 101};
        return Arrays.asList(percents);
    }

    private List<Integer> createLootPercentList() {
        Integer[] percents = new Integer[]{16, 26, 41, 56, 76, 86, 96, 101};
        return Arrays.asList(percents);
    }

    private String createDescription() {
        return "The School seems very friendly, just some lightweight enemies staying here, protecting a very misc loot";
    }

    private int createRadiationLevel() {
        return 5;
    }

}
