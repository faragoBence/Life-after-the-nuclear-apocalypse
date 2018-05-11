package com.codecool.web.dao.implementations;

import com.codecool.web.dao.ItemDao;
import com.codecool.web.model.items.Item;
import com.codecool.web.model.items.ItemFactory;
import com.codecool.web.model.items.ItemFactoryImpl;
import com.codecool.web.model.items.Weapon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class ItemDatabaseDao extends AbstractDaoFactory implements ItemDao {
    ItemFactory itemFactory = new ItemFactoryImpl();

    protected ItemDatabaseDao(Connection connection) {
        super(connection);
    }

    @Override
    public void InsertItemToBackPack(String name, int backPackId) throws SQLException {
        String sql = "INSERT INTO items (name, backpack_id) VALUES (?, ?);";
        insertItem(name, backPackId, sql);

    }

    @Override
    public void InsertItemToOutpost(String name, int outpostId) throws SQLException {
        String sql = "INSERT INTO items (name, outpost_id) VALUES (?, ?);";
        insertItem(name, outpostId, sql);

    }


    private void insertItem(String name, int id, String sql) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, id);
            executeInsert(statement);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }

    @Override
    public void InsertWeaponToBackpack(String name, int durability, int backPackId) throws SQLException {
        String sql = "INSERT INTO items (name, backpack_id,durability) VALUES (?, ?, ?);";
        connection.setAutoCommit(false);
        insertWeapon(name, durability, backPackId, sql);
    }

    @Override
    public void InsertWeaponToOutpost(String name, int durability, int outpostId) throws SQLException {
        String sql = "INSERT INTO items (name, outpost_id,durability) VALUES (?, ?, ?);";
        connection.setAutoCommit(false);
        insertWeapon(name, durability, outpostId, sql);
    }

    private void insertWeapon(String name, int durability, int id, String sql) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.setInt(3, durability);
            executeInsert(statement);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }

    @Override
    public List<Item> findItemsByBackPackId(int backPackId) throws SQLException {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE backpack_id = ? AND durability = NULL;";
        findItems(backPackId, items, sql);
        return items;
    }

    @Override
    public List<Item> findItemsByOutpostId(int outpostId) throws SQLException {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE outpost_id = ? AND durability = NULL;";
        findItems(outpostId, items, sql);
        return items;
    }

    private void findItems(int id, List<Item> items, String sql) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(fetchItem(resultSet));
            }
        }
    }

    @Override
    public List<Weapon> findWeaponsByBackPackId(int backPackId) throws SQLException {
        List<Weapon> weapons = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE backpack_id = ? AND durability <> NULL;";
        findWeapons(backPackId, weapons, sql);
        return weapons;
    }

    @Override
    public List<Weapon> findWeaponsByOutpostId(int outpostId) throws SQLException {
        List<Weapon> weapons = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE outpost_id = ? AND durability <> NULL;";
        findWeapons(outpostId, weapons, sql);
        return weapons;
    }

    private void findWeapons(int id, List<Weapon> weapons, String sql) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                weapons.add(fetchWeapon(resultSet));
            }
        }
    }

    @Override
    public Item findItem(int id) throws SQLException {
        String sql = "SELECT * FROM items WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return fetchItem(resultSet);
            }
        }
        return null;
    }

    @Override
    public Weapon findWeapon(int id) throws SQLException {
        String sql = "SELECT * FROM items WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return fetchWeapon(resultSet);
            }
        }
        return null;
    }

    @Override
    public void deleteItem(int id) throws SQLException {
        String sql = "DELETE FROM items WHERE id = ?; ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }

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
