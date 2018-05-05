package com.codecool.web.dao.implementations;

import com.codecool.web.dao.ItemDao;
import com.codecool.web.model.items.Item;
import com.codecool.web.model.items.Weapon;

import java.util.List;

public class ItemDatabaseDao implements ItemDao {
    @Override
    public void InsertItemToBackPack(String name, int BackPackid) {

    }

    @Override
    public void InsertItemToOustpost(String name, int OutpostId) {

    }

    @Override
    public void InsertWeaponToBackpack(String name, int durability, int BackPackId) {

    }

    @Override
    public void InsertWeaponToOutpost(String name, int durability, int OutpostId) {

    }

    @Override
    public List<Item> findItemsByBackPackId(int BackPackId) {
        return null;
    }

    @Override
    public List<Item> findItemsByOutpostId(int OutpostId) {
        return null;
    }

    @Override
    public List<Weapon> findWeaponsByBackPackId(int BackPackId) {
        return null;
    }

    @Override
    public List<Weapon> findWeaponsByOutpostId(int OutpostId) {
        return null;
    }

    @Override
    public Item findItem(int id) {
        return null;
    }

    @Override
    public Weapon findWeapon(int id) {
        return null;
    }

    @Override
    public void deleteItem(int id) {

    }
}
