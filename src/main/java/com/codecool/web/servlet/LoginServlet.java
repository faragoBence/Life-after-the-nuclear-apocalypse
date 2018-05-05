package com.codecool.web.servlet;


import com.codecool.web.dao.SurvivorDao;
import com.codecool.web.dao.UserDao;
import com.codecool.web.dao.implementations.SurvivorDatabaseDao;
import com.codecool.web.dao.implementations.UserDatabaseDao;
import com.codecool.web.dto.UserSurvivorDto;
import com.codecool.web.exception.UserNotFoundException;
import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.User;
import com.codecool.web.model.survivors.Survivor;
import com.codecool.web.service.SurvivorService;
import com.codecool.web.service.implementations.SurvivorServiceImpl;
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
            UserDao userDao = new UserDatabaseDao(connection);
            SurvivorDao survivorDao = new SurvivorDatabaseDao(connection);
            UserServiceImpl userServiceDao = new UserServiceImpl(userDao);
            SurvivorService survivorService = new SurvivorServiceImpl(survivorDao);
            User currentUser = userServiceDao.login(email, password);
            Survivor survivor = survivorService.findSurvivor(currentUser);
            req.getSession().setAttribute("user", currentUser);
            req.getSession().setAttribute("survivor", survivor);
            sendMessage(resp, HttpServletResponse.SC_OK, new UserSurvivorDto(currentUser,survivor));
        } catch (SQLException e) {
            handleSqlError(resp,e);
        } catch (UserNotFoundException e) {
            sendMessage(resp,HttpServletResponse.SC_BAD_REQUEST, "User not found! Please register first!");
        } catch (WrongPasswordException e) {
            sendMessage(resp,HttpServletResponse.SC_BAD_REQUEST, "Wrong password entered!");
        }
    }
}
