package com.codecool.web.servlet;

import com.codecool.web.dto.MessageDto;
import com.codecool.web.model.Backpack;
import com.codecool.web.model.User;
import com.codecool.web.model.locations.Outpost;
import com.codecool.web.model.survivors.Survivor;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

abstract class AbstractServlet extends HttpServlet {
    private final ObjectMapper om = new ObjectMapper();

    Connection getConnection(ServletContext sce) throws SQLException {
        DataSource dataSource = (DataSource) sce.getAttribute("dataSource");
        return dataSource.getConnection();
    }

    void sendMessage(HttpServletResponse resp, int status, String message) throws IOException {
        sendMessage(resp, status, new MessageDto(message));
    }

    void sendMessage(HttpServletResponse resp, int status, Object object) throws IOException {
        resp.setStatus(status);
        om.writeValue(resp.getOutputStream(), object);
    }

    void handleSqlError(HttpServletResponse resp, SQLException ex) throws IOException {
        sendMessage(resp, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        ex.printStackTrace();
    }


    Survivor getSurvivor(HttpServletRequest req) {
        return (Survivor) req.getSession().getAttribute("survivor");
    }

    User getUser(HttpServletRequest req) {
        return (User) req.getSession().getAttribute("user");
    }

    Outpost getOutpost(HttpServletRequest req) {
        return (Outpost) req.getSession().getAttribute("outpost");
    }

    Backpack getBackpack(HttpServletRequest req) {
        return (Backpack) req.getSession().getAttribute("backpack");
    }
}
