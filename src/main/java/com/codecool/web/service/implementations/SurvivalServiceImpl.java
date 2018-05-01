package com.codecool.web.service.implementations;

import com.codecool.web.model.Survivor;
import com.codecool.web.model.locations.Outpost;
import com.codecool.web.service.SurvivalService;

public class SurvivalServiceImpl implements SurvivalService {

    public Survivor createSurvivor(String name) {
        return new Survivor(name, 2, 100, 100, 100, 5, 3,"Outpost");
    }

    public void eating(Survivor survivor) {

    }

    public Survivor findSurvivor(String name, Outpost outpostt) {
        return null;
    }

    public void healing(Survivor survivor) {

    }

    public void rest(Survivor survivor) {

    }

    public void build(Survivor survivor) {

    }
    public void crafting(Survivor survivor) {

    }

    public void bonuses(Survivor survivor) {
      /*  if (containsFurnitures("Bed")) {
            survivor.setActionPoints(-survivor.getActionPoints() + 3);
        }
        if (containsFurnitures("Refrigerator")) {
            addTo(new Food("Canned food", 35, 0));
        }
        if (containsFurnitures("Pottery")) {
            addTo(new Food("Apple", 10, -2));
        }
        if (containsFurnitures("Gym")) {
            survivor.setStrength(7);
        }
        if (containsFurnitures("Insulation")) {
            survivor.setRadiationLevel(10);
        }
        if (containsFurnitures("Water Purifier")) {
            addTo(new Food("Fresh water", 25, -5));
            */
    }

}


