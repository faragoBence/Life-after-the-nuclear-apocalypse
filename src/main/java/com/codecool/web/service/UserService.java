package com.codecool.web.service;

import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.exception.UserNotFoundException;
import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.User;

import java.sql.SQLException;

public interface UserService {

    String story();

    String help();

    void register(String name, String email, String password) throws UserAlreadyRegisteredException, SQLException;

    boolean containsUser(String email);

    User login(String email, String password) throws WrongPasswordException, SQLException, UserNotFoundException;

    User login(String email);

    User changeName(String newName,String Password);

    User changePassword(String newPassword,String oldPassword);
}
