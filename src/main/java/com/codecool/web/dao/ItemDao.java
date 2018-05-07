package com.codecool.web.dao;

import com.codecool.web.model.items.Item;
import com.codecool.web.model.items.Weapon;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao {

    void InsertItemToBackPack(String name,int backPackId) throws SQLException;

    void InsertItemToOutpost(String name,int outpostId) throws SQLException;

    void InsertWeaponToBackpack(String name, int durability,int backPackId) throws SQLException;

    void InsertWeaponToOutpost(String name, int durability,int outpostId) throws SQLException;

    List<Item> findItemsByBackPackId(int backPackId) throws SQLException;

    List<Item> findItemsByOutpostId(int outpostId) throws SQLException;

    List<Weapon> findWeaponsByBackPackId(int backPackId) throws SQLException;

    List<Weapon> findWeaponsByOutpostId(int outpostId) throws SQLException;

    Item findItem(int id) throws SQLException;

    Weapon findWeapon(int id) throws SQLException;

    void deleteItem(int id) throws SQLException;


}
