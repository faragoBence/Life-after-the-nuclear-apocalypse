package com.codecool.web.service;

import com.codecool.web.model.locations.Outpost;
import com.codecool.web.model.survivors.Survivor;

public interface SurvivalService {

    void eating(Survivor survivor);

    Survivor findSurvivor(String name, Outpost outpost);

    void healing(Survivor survivor);

    void rest(Survivor survivor);

    void build(Survivor survivor);

    void crafting(Survivor survivor);

    void bonuses(Survivor survivor);

}
