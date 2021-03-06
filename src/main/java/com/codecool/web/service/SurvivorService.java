package com.codecool.web.service;

import com.codecool.web.exception.PlayerIsDeadException;
import com.codecool.web.model.Backpack;
import com.codecool.web.model.User;
import com.codecool.web.model.items.Food;
import com.codecool.web.model.survivors.Survivor;

import java.sql.SQLException;

public interface SurvivorService {

    Survivor createSurvivor(String name,String type,String fraction, int userId, int outpostId) throws SQLException;

    Backpack findSurvivorBackPack(int survivorId) throws SQLException;

    void eating(Survivor survivor,Food food) throws PlayerIsDeadException, SQLException;

    Survivor findSurvivor(User user) throws SQLException;

    void healing(Survivor survivor);

    void rest(Survivor survivor) throws SQLException, PlayerIsDeadException;

    void build(Survivor survivor);

    void crafting(Survivor survivor);

    void bonuses(Survivor survivor);

}
