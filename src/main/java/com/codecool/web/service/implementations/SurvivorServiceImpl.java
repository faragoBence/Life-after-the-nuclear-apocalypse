package com.codecool.web.service.implementations;

import com.codecool.web.dao.SurvivorDao;
import com.codecool.web.exception.PlayerIsDeadException;
import com.codecool.web.model.User;
import com.codecool.web.model.items.Food;
import com.codecool.web.model.survivors.Survivor;
import com.codecool.web.model.survivors.SurvivorFactory;
import com.codecool.web.model.survivors.SurvivorFactoryImpl;
import com.codecool.web.service.SurvivorService;

import java.sql.SQLException;

public class SurvivorServiceImpl implements SurvivorService {

    private final SurvivorDao dao;

    public SurvivorServiceImpl(SurvivorDao dao) {
        this.dao = dao;
    }


    @Override
    public Survivor createSurvivor(String name, String type, int userId) throws SQLException {
        SurvivorFactory survivorFactory = new SurvivorFactoryImpl();
        Survivor survivor = survivorFactory.createSurvivor(name,type);
        dao.insertSurvivor(userId,survivor);
        return dao.findSurvivorbyUserId(userId);
    }

    public void eating(Survivor survivor, Food food) {
    }

    public Survivor findSurvivor(User user) throws SQLException {
        return dao.findSurvivorbyUserId(user.getId());
    }

    public void healing(Survivor survivor) {

    }

    public void rest(Survivor survivor) throws SQLException, PlayerIsDeadException {
        dao.updateActionPoints(survivor.getId(),survivor.getMaxActionPoints());
        survivor.setHungerLevel(-35);
        dao.updateHungerLevel(survivor.getId(),survivor.getHungerLevel());
        survivor.setRadiationLevel(-10);
        dao.updateRadiationLevel(survivor.getId(),survivor.getRadiationLevel());
    }

    public void build(Survivor survivor) {

    }
    public void crafting(Survivor survivor) {

    }

    public void bonuses(Survivor survivor) {
      /*  if (containsFurnitures("Bed")) {
            survivor.setActionPoints(-survivor.getActionPoints() + 3);
        }
        if (containsFurnitures("Refrigerator")) {
            addTo(new Food("Canned food", 35, 0));
        }
        if (containsFurnitures("Pottery")) {
            addTo(new Food("Apple", 10, -2));
        }
        if (containsFurnitures("Gym")) {
            survivor.setStrength(7);
        }
        if (containsFurnitures("Insulation")) {
            survivor.setRadiationLevel(10);
        }
        if (containsFurnitures("Water Purifier")) {
            addTo(new Food("Fresh water", 25, -5));
            */
    }

}


