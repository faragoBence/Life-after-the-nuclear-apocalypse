package com.codecool.web.dao.implementations;

import com.codecool.web.dao.BackPackDao;
import com.codecool.web.model.Backpack;
import com.codecool.web.model.items.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BackPackDatabaseDao extends AbstractDao implements BackPackDao {

    public BackPackDatabaseDao(Connection connection) {
        super(connection);
    }

    @Override
    public void insertBackPack(int survivorId, int maxSlots) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO backpacks (survivor_id, max_slots) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, survivorId);
            statement.setInt(2, maxSlots);
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
    public Backpack findById(int id) throws SQLException {
        String sql = "SELECT * FROM backpacks WHERE id = ?;";
        return find(id, sql);
    }

    @Override
    public Backpack findByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM backpacks WHERE user_id = ?;";
        return find(userId, sql);
    }

    private Backpack find(int id, String sql) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return fetchBackpack(resultSet, new ArrayList<>());
            }
        }
        return null;
    }

    @Override
    public void updateMaxSlots(int id, int maxSlots) throws SQLException {
        String sql = "UPDATE backpacks SET max_slots = ? WHERE id = ?;";
        update(id, maxSlots, sql);

    }

    private Backpack fetchBackpack(ResultSet resultSet, List<Item> items) throws SQLException {
        int id = resultSet.getInt("id");
        int maxSlots = resultSet.getInt("max_slots");
        return new Backpack(id, items, maxSlots);
    }
}
