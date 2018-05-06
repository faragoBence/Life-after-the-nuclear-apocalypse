package com.codecool.web.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDaoFactory {
    private static BackPackDatabaseDao backPackDatabaseDao;
    private static AbstractDaoFactory itemDatabaseDao;
    private static AbstractDaoFactory outpostDatabaseDao;
    private static AbstractDaoFactory survivorDatabaseDao;
    private static AbstractDaoFactory userDatabaseDao;

    Connection connection;

    AbstractDaoFactory(Connection connection) {
        this.connection = connection;
    }

    public static AbstractDaoFactory getDao(String daoType, Connection connection) {
        AbstractDaoFactory dao;
        switch (daoType){
            case "backpack":
                if(backPackDatabaseDao == null) {
                    backPackDatabaseDao = new BackPackDatabaseDao(connection);
                }
                dao =backPackDatabaseDao;
                break;
            case "item":
                if(itemDatabaseDao == null) {
                    itemDatabaseDao = new ItemDatabaseDao(connection);
                }
                dao =itemDatabaseDao;
                break;
            case "outpost":
                if(outpostDatabaseDao == null) {
                    outpostDatabaseDao = new OutpostDatabaseDao(connection);
                }
                dao =outpostDatabaseDao;
                break;
            case "survivor":
                if(survivorDatabaseDao == null) {
                    survivorDatabaseDao = new SurvivorDatabaseDao(connection);
                }
                dao =survivorDatabaseDao;
                break;
            case "user":
                if(userDatabaseDao == null) {
                    userDatabaseDao = new UserDatabaseDao(connection);
                }
                dao = userDatabaseDao;
                break;
            default:
                return null;
        }
        return dao;
    }

    void executeInsert(PreparedStatement statement) throws SQLException {
        int insertCount = statement.executeUpdate();
        if (insertCount != 1) {
            connection.rollback();
            throw new SQLException("Expected 1 row to be inserted");
        }
    }

    int fetchGeneratedId(PreparedStatement statement) throws SQLException {
        int id;
        try (ResultSet resultSet = statement.getGeneratedKeys()) {
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            } else {
                connection.rollback();
                throw new SQLException("Expected 1 result");
            }
        }
        connection.commit();
        return id;
    }

    void update(int id, String updateAble, String sql) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, updateAble);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }
    void update(int id, int updateAble , String sql) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, updateAble);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }
}
