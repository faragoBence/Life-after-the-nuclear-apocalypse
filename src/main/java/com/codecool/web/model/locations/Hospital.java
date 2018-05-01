package com.codecool.web.model.locations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Hospital extends Location
{

    private static final Hospital hospital = new Hospital();

    private Hospital(){
        hospital.setName("Hospital");
        hospital.setLootable(createLootableList(createItemNameList()));
        hospital.setEnemies(createCreaturesList(createCreatureNameList()));
        hospital.setEnemyPercent(createEnemyPercentList());
        hospital.setLootPercent(createLootPercentList());
        hospital.setRadiationLevel(createRadiationLevel());
        hospital.setDescription(createDescription());
    }

    static Location getInstance() {
        return hospital;
    }

    private List<String> createItemNameList() {
        List<String> names = new ArrayList<>();
        names.add("Radaway");
        names.add("Painkiller");
        names.add("Vodka");
        names.add("Stimpak");
        names.add("Nuka cola");
        names.add("First aid kit");
        names.add("Fresh water");
        names.add("Handgun");
        return names;

    }

    private List<String> createCreatureNameList() {
        List<String> names = new ArrayList<>();
        names.add("Scarvanger");
        names.add("Zombie");
        names.add("Ghoul");
        names.add("Bandit");
        names.add("Super human");
        names.add("Infested hound");
        return names;
    }

    private List<Integer> createEnemyPercentList() {
        Integer[] percents = new Integer[]{11, 26, 36, 51, 76, 101};
        return Arrays.asList(percents);
    }

    private List<Integer> createLootPercentList() {
        Integer[] percents = new Integer[]{16, 31, 46, 61, 71, 91, 96, 101};
        return Arrays.asList(percents);
    }

    private String createDescription() {
        return "The Hospital is abandoned by human's centuries ago.The most of the Medicine can be found here.Some infested creature and scarvangers are protecting the place";
    }

    private int createRadiationLevel() {
        return 15;
    }
}
