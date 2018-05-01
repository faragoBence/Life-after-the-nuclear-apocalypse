package com.codecool.web.model.locations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GasStation extends Location {

    private static final GasStation gasStation = new GasStation();

    private GasStation(){
        gasStation.setName("GasStation");
        gasStation.setLootable(createLootableList(createItemNameList()));
        gasStation.setEnemies(createCreaturesList(createCreatureNameList()));
        gasStation.setEnemyPercent(createEnemyPercentList());
        gasStation.setLootPercent(createLootPercentList());
        gasStation.setRadiationLevel(createRadiationLevel());
        gasStation.setDescription(createDescription());
    }

    private static List<String> createCreatureNameList() {
        List<String> names = new ArrayList<>();
        names.add("Ghoul");
        names.add("Bandit");
        names.add("Scarvanger");
        names.add("Super human");
        names.add("Infested bear");
        return names;
    }

    public static Location getInstance() {
        return gasStation;
    }

    private List<String> createItemNameList() {
        List<String> names = new ArrayList<>();
        names.add("Stimpak");
        names.add("Vodka");
        names.add("Radaway");
        names.add("Canned food");
        names.add("Nuka cola");
        names.add("Fresh water");
        names.add("Corn");
        names.add("Knife");
        names.add("Baseball bat");
        return names;
    }

    private List<Integer> createEnemyPercentList() {

        Integer[] percents = new Integer[]{26, 51, 71, 91, 101};
        return Arrays.asList(percents);
    }

    private List<Integer> createLootPercentList() {
        Integer[] percents = new Integer[]{11, 21, 31, 51, 66, 81, 91, 96, 101};
        return Arrays.asList(percents);
    }

    private String createDescription() {
        return "It looks like the GasStation is almost empty, but the most of the food are leaved here.Also it is occupied by bandit's and scarvangers.";
    }

    private int createRadiationLevel() {
        return 10;
    }
}
