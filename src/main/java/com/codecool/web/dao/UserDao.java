package com.codecool.web.dao;

import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.User;

import java.sql.SQLException;

public interface UserDao  {

    void insertUser(String name,String email, String password) throws SQLException;

    User findUserbyEmail(String email) throws SQLException;

    void updateName(int userId,String newName) throws SQLException;

    void updatePassword(int userId,String newPassword) throws SQLException;

    User findUserbyEmailAndPassword(String email,String password) throws WrongPasswordException, SQLException;
}
