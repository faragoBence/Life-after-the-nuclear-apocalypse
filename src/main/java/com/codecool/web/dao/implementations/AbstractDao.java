package com.codecool.web.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class AbstractDao {

    final Connection connection;

    AbstractDao(Connection connection) {
        this.connection = connection;
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

    void update(int id, String updateAble, boolean autoCommit, String sql) throws SQLException {
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
    void update(int id, int updateAble, boolean autoCommit, String sql) throws SQLException {
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
