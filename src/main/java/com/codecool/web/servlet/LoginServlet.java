package com.codecool.web.servlet;


import com.codecool.web.dao.implementations.UserDatabaseDao;
import com.codecool.web.exception.UserNotFoundException;
import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.User;
import com.codecool.web.service.implementations.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/login")
public class LoginServlet extends AbstractServlet {


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try (Connection connection = getConnection(req.getServletContext())) {
            UserDatabaseDao userDao = new UserDatabaseDao(connection);
            UserServiceImpl userServiceDao = new UserServiceImpl(userDao);
            User currentUser = userServiceDao.login(email, password);
            req.getSession().setAttribute("user", currentUser);
            sendMessage(resp, HttpServletResponse.SC_OK, currentUser);
        } catch (SQLException e) {
            handleSqlError(resp,e);
        } catch (UserNotFoundException e) {
            sendMessage(resp,HttpServletResponse.SC_BAD_REQUEST, "User not found! Please register first!");
        } catch (WrongPasswordException e) {
            sendMessage(resp,HttpServletResponse.SC_BAD_REQUEST, "Wrong password entered!");
        }
    }
}
