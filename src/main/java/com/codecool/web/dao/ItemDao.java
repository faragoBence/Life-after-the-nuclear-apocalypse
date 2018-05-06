package com.codecool.web.dao;

import com.codecool.web.model.items.Item;
import com.codecool.web.model.items.Weapon;

import java.util.List;

public interface ItemDao {

    void InsertItemToBackPack(String name,int BackPackId);

    void InsertItemToOutpost(String name,int OutpostId);

    void InsertWeaponToBackpack(String name, int durability,int BackPackId);

    void InsertWeaponToOutpost(String name, int durability,int OutpostId);

    List<Item> findItemsByBackPackId(int BackPackId);

    List<Item> findItemsByOutpostId(int OutpostId);

    List<Weapon> findWeaponsByBackPackId(int BackPackId);

    List<Weapon> findWeaponsByOutpostId(int OutpostId);

    Item findItem(int id);

    Weapon findWeapon(int id);

    void deleteItem(int id);


}
