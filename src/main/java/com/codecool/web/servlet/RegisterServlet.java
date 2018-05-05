package com.codecool.web.servlet;

import com.codecool.web.dao.SurvivorDao;
import com.codecool.web.dao.UserDao;
import com.codecool.web.dao.implementations.SurvivorDatabaseDao;
import com.codecool.web.dao.implementations.UserDatabaseDao;
import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.exception.UserNotFoundException;
import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.User;
import com.codecool.web.service.SurvivorService;
import com.codecool.web.service.UserService;
import com.codecool.web.service.implementations.SurvivorServiceImpl;
import com.codecool.web.service.implementations.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/register")
public class RegisterServlet extends AbstractServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String survivorName = req.getParameter("survivorName");
        String type = req.getParameter("type");

        try (Connection connection = getConnection(req.getServletContext())) {
            UserDao userDao = new UserDatabaseDao(connection);
            SurvivorDao survivorDao = new SurvivorDatabaseDao(connection);
            UserService userService = new UserServiceImpl(userDao);
            SurvivorService survivorService = new SurvivorServiceImpl(survivorDao);
            userService.register(name, email, password);
            User user = userService.login(email, password);
            survivorService.createSurvivor(survivorName, type.toUpperCase(), user.getId());
            sendMessage(resp, HttpServletResponse.SC_OK, "Registration is successful you can log in now!");
        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (UserAlreadyRegisteredException e) {
            sendMessage(resp, HttpServletResponse.SC_BAD_REQUEST, "You are already registered!");
        } catch (UserNotFoundException e) {
            sendMessage(resp, HttpServletResponse.SC_BAD_REQUEST, "User not found! Please register first!");
        } catch (WrongPasswordException e) {
            sendMessage(resp, HttpServletResponse.SC_BAD_REQUEST, "Wrong password entered!");
        }
    }
}
