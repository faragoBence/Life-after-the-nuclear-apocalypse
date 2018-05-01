package com.codecool.web.servlet;

import com.codecool.web.dao.implementations.UserDaoImpl;
import com.codecool.web.exception.UserAlreadyRegisteredException;
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

        try (Connection connection = getConnection(req.getServletContext())) {
            UserDaoImpl userDao = new UserDaoImpl(connection);
            UserServiceImpl userServiceDao = new UserServiceImpl(userDao);
            userServiceDao.register(name, email, password);
            sendMessage(resp, HttpServletResponse.SC_OK, "Registration is successful you can log in now!");
        } catch (SQLException e) {
            handleSqlError(resp, e);
        } catch (UserAlreadyRegisteredException e) {
            sendMessage(resp, HttpServletResponse.SC_BAD_REQUEST, "You are already registered!");
        }
    }
}
