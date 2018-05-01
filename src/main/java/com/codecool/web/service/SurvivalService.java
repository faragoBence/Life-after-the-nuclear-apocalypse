package com.codecool.web.service;

import com.codecool.web.model.Survivor;
import com.codecool.web.model.locations.Outpost;

public interface SurvivalService {

    Survivor createSurvivor(String name);

    void eating(Survivor survivor);

    Survivor findSurvivor(String name, Outpost outpost);

    void healing(Survivor survivor);

    void rest(Survivor survivor);

    void build(Survivor survivor);

    void crafting(Survivor survivor);

    void bonuses(Survivor survivor);

}
