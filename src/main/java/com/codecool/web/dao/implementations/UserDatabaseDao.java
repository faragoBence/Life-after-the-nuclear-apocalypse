package com.codecool.web.dao.implementations;

import com.codecool.web.dao.UserDao;
import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabaseDao extends AbstractDao implements UserDao {


    public UserDatabaseDao(Connection connection) {
        super(connection);
    }

    @Override
    public void insertUser(String name, String email, String password) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
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
    public User findUserbyEmail(String email) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return fetchUser(resultSet);
            }
        }
        return null;
    }

    @Override
    public void updateName(int userId,String newName) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "UPDATE users SET name = ? WHERE id = ?;";
        update(userId, newName, autoCommit, sql);
    }

    @Override
    public void updatePassword(int userId,String newPassword) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "UPDATE users SET password = ? WHERE id = ?;";
        update(userId, newPassword, autoCommit, sql);
    }

    @Override
    public User findUserbyEmailAndPassword(String email, String password) throws WrongPasswordException, SQLException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return fetchUser(resultSet);
            }
        }
        throw new WrongPasswordException();
    }

    @Override
    public User fetchUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        return new User(id,name,email,password);
    }
}
