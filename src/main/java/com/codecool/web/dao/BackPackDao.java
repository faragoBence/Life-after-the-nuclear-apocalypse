package com.codecool.web.dao;

import com.codecool.web.model.Backpack;

import java.sql.SQLException;

public interface BackPackDao {

    void insertBackPack(int survivorId,int maxSlots) throws SQLException;

    Backpack findById(int id) throws SQLException;

    Backpack findByUserId(int userId) throws SQLException;

    void updateMaxSlots(int id, int maxSlots) throws SQLException;
}
