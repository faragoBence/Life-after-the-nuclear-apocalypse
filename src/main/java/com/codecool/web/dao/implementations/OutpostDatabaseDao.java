package com.codecool.web.dao.implementations;

import com.codecool.web.dao.OutpostDao;
import com.codecool.web.model.locations.Outpost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class OutpostDatabaseDao extends AbstractDaoFactory implements OutpostDao {

    protected OutpostDatabaseDao(Connection connection) {
        super(connection);
    }

    @Override
    public void insertOutpost(String name) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO outposts (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
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
    public Outpost findOutpost(int id) throws SQLException {
        String sql = "SELECT * FROM outposts WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return fetchOutpost(resultSet);
            }
        }
        return null;
    }

    @Override
    public Outpost findOutpost(String name) throws SQLException {
        String sql = "SELECT * FROM outposts WHERE name = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return fetchOutpost(resultSet);
            }
        }
        return null;
    }

    @Override
    public List<Outpost> findAll() throws SQLException {
        List<Outpost> outposts = new ArrayList<>();
        String sql = "SELECT * FROM outposts;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                outposts.add(fetchOutpost(resultSet));
            }
        }
        return outposts;
    }

    private Outpost fetchOutpost(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        return new Outpost(id,name);
    }
}
