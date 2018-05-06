package com.codecool.web.servlet;

import com.codecool.web.dto.SurvivorDto;
import com.codecool.web.exception.PlayerIsDeadException;
import com.codecool.web.model.User;
import com.codecool.web.model.locations.Outpost;
import com.codecool.web.model.survivors.Survivor;
import com.codecool.web.service.SurvivorService;
import com.codecool.web.service.implementations.SurvivorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
@WebServlet("/protected/rest")
public class RestServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            SurvivorService survivorService = new SurvivorServiceImpl(connection);
            Survivor survivor = (Survivor) req.getSession().getAttribute("survivor");
            User user = (User) req.getSession().getAttribute("user");
            Outpost outpost = (Outpost) req.getSession().getAttribute("outpost");
            survivorService.rest(survivor);
            survivor = survivorService.findSurvivor(user);
            req.getSession().setAttribute("survivor",survivor);
            sendMessage(resp, HttpServletResponse.SC_OK, new SurvivorDto(user,survivor,outpost));
        } catch (SQLException e) {
            handleSqlError(resp,e);
        } catch (PlayerIsDeadException e) {
            sendMessage(resp,HttpServletResponse.SC_BAD_REQUEST, "Player is dead!");
        }
    }
}
