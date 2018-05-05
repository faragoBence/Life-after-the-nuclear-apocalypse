package com.codecool.web.dao.implementations;

import com.codecool.web.dao.SurvivorDao;
import com.codecool.web.model.survivors.Survivor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurvivorDatabaseDao extends AbstractDao implements SurvivorDao {

    public SurvivorDatabaseDao(Connection connection) {
        super(connection);
    }

    @Override
    public void insertSurvivor(int userId, Survivor survivor) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO survivors (name, user_id, action_points, max_action_points, hunger, max_hunger, health, radiation, max_radiation, strength, agility, location, type ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, survivor.getName());
            statement.setInt(2, userId);
            statement.setInt(3, survivor.getActionPoints());
            statement.setInt(4, survivor.getMaxActionPoints());
            statement.setInt(5, survivor.getHungerLevel());
            statement.setInt(6, survivor.getMaxHungerLevel());
            statement.setInt(7, survivor.getHealth());
            statement.setInt(8, survivor.getRadiationLevel());
            statement.setInt(9, survivor.getMaxRadiationLevel());
            statement.setInt(10, survivor.getStrength());
            statement.setInt(11, survivor.getAgility());
            statement.setString(12, survivor.getCurrentLocation());
            statement.setString(13, survivor.getType());
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
    public Survivor findSurvivorbyUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM survivors WHERE user_id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return fetchSurvivor(resultSet);
            }
        }
        return null;
    }

    @Override
    public void updateHealth(int survivorId, int health) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "UPDATE survivors SET health = ? WHERE id = ?;";
        update(survivorId, health, autoCommit, sql);
    }

    @Override
    public void updateRadiationLevel(int survivorId, int radiationLevel) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "UPDATE survivors SET radiation = ? WHERE id = ?;";
        update(survivorId, radiationLevel, autoCommit, sql);
    }

    @Override
    public void updateActionPoints(int survivorId, int actionPoints) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "UPDATE survivors SET action_points = ? WHERE id = ?;";
        update(survivorId, actionPoints, autoCommit, sql);
    }

    @Override
    public void updateHungerLevel(int survivorId, int hungerLevel) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "UPDATE survivors SET hunger = ? WHERE id = ?;";
        update(survivorId, hungerLevel, autoCommit, sql);
    }

    @Override
    public void updateLocation(int survivorId, String location) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "UPDATE survivors SET location = ? WHERE id = ?;";
        update(survivorId, location, autoCommit, sql);
    }

    public Survivor fetchSurvivor(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int health = resultSet.getInt("health");
        int strength = resultSet.getInt("strength");
        int agility = resultSet.getInt("agility");
        int actionPoints = resultSet.getInt("action_points");
        int maxActionPoints = resultSet.getInt("max_action_points");
        int hungerLevel = resultSet.getInt("hunger");
        int maxHungerLevel = resultSet.getInt("max_hunger");
        int radiationLevel = resultSet.getInt("radiation");
        int maxRadiationLevel = resultSet.getInt("max_radiation");
        String currentLocation = resultSet.getString("location");
        String type = resultSet.getString("type");
        Survivor survivor = new Survivor(name, actionPoints, maxActionPoints, hungerLevel, maxHungerLevel, health, radiationLevel, maxRadiationLevel, strength, agility, currentLocation, type);
        survivor.setId(id);
        return survivor;
    }


}