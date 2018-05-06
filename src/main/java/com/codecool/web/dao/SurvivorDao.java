package com.codecool.web.dao;

import com.codecool.web.model.survivors.Survivor;

import java.sql.SQLException;
import java.util.List;

public interface SurvivorDao {
    void insertSurvivor(int userId, Survivor survivor,int outpostId) throws SQLException;

    Survivor findSurvivorbyUserId(int userId) throws SQLException;

    List<Survivor> findSurvivorsByOutpostId(int outpostId) throws SQLException;

    void updateHealth(int survivorId, int health) throws SQLException;

    void updateRadiationLevel(int survivorId, int radiationLevel) throws SQLException;

    void updateActionPoints(int survivorId, int actionPoints) throws SQLException;

    void updateHungerLevel(int survivorId, int hungerLevel) throws SQLException;

    void updateLocation(int survivorId, String location) throws SQLException;
}
