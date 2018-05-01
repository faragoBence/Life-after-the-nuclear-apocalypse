package com.codecool.web.service;

import com.codecool.web.model.locations.Outpost;
import com.codecool.web.model.survivors.Survivor;

import java.sql.SQLException;

public interface SurvivorService {

    Survivor createSurvivor(String name,String type,int userId) throws SQLException;

    void eating(Survivor survivor);

    Survivor findSurvivor(String name, Outpost outpost);

    void healing(Survivor survivor);

    void rest(Survivor survivor);

    void build(Survivor survivor);

    void crafting(Survivor survivor);

    void bonuses(Survivor survivor);

}
