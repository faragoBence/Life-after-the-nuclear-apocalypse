package com.codecool.web.dao.implementations;

import com.codecool.web.dao.ItemDao;
import com.codecool.web.model.items.Item;
import com.codecool.web.model.items.ItemFactory;
import com.codecool.web.model.items.ItemFactoryImpl;
import com.codecool.web.model.items.Weapon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class ItemDatabaseDao extends AbstractDaoFactory implements ItemDao {
    ItemFactory itemFactory = new ItemFactoryImpl();

    protected ItemDatabaseDao(Connection connection) {
        super(connection);
    }

    @Override
    public void InsertItemToBackPack(String name, int BackPackId) {

    }

    @Override
    public void InsertItemToOutpost(String name, int OutpostId) {

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

    private Item fetchItem(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Item item = itemFactory.getItem(name);
        item.setId(id);
        return item;
    }

    private Weapon fetchWeapon(ResultSet resultSet) throws SQLException {
        Weapon weapon = (Weapon) fetchItem(resultSet);
        int durability = resultSet.getInt("durability");
        weapon.setDurability(durability);
        return weapon;
    }
}
