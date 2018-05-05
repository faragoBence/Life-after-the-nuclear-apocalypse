package com.codecool.web.dao;

import com.codecool.web.model.Backpack;

public interface BackPackDao {

    void insertBackPack(int survivorId,int MaxSlots);

    Backpack findById(int id);

    Backpack findByUserId(int userId);

    void updateMaxSlots(int id, int maxSlots);
}
