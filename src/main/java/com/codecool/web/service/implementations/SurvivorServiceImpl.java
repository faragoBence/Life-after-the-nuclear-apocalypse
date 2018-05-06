package com.codecool.web.service.implementations;

import com.codecool.web.dao.BackPackDao;
import com.codecool.web.dao.SurvivorDao;
import com.codecool.web.dao.implementations.AbstractDaoFactory;
import com.codecool.web.exception.PlayerIsDeadException;
import com.codecool.web.model.Backpack;
import com.codecool.web.model.User;
import com.codecool.web.model.items.Food;
import com.codecool.web.model.survivors.Survivor;
import com.codecool.web.model.survivors.SurvivorFactory;
import com.codecool.web.model.survivors.SurvivorFactoryImpl;
import com.codecool.web.service.SurvivorService;

import java.sql.Connection;
import java.sql.SQLException;

public class SurvivorServiceImpl implements SurvivorService {

    private final SurvivorDao survivorDao;
    private final BackPackDao backpackDao;

    public SurvivorServiceImpl(Connection connection) {
        survivorDao = (SurvivorDao) AbstractDaoFactory.getDao("survivor",connection);
        backpackDao = (BackPackDao) AbstractDaoFactory.getDao("backpack",connection);

    }


    @Override
    public Survivor createSurvivor(String name, String type,String fraction, int userId, int outpostId) throws SQLException {
        SurvivorFactory survivorFactory = new SurvivorFactoryImpl();
        Survivor survivor = survivorFactory.createSurvivor(name,type,fraction);
        survivorDao.insertSurvivor(userId,survivor,outpostId);
        backpackDao.insertBackPack(survivor.getId(),8);
        return survivorDao.findSurvivorbyUserId(userId);
    }

    @Override
    public Backpack findSurvivorBackPack(int survivorId) throws SQLException {
        return backpackDao.findBySurvivorId(survivorId);
    }

    public void eating(Survivor survivor, Food food) {
    }

    public Survivor findSurvivor(User user) throws SQLException {
        return survivorDao.findSurvivorbyUserId(user.getId());
    }

    public void healing(Survivor survivor) {

    }

    public void rest(Survivor survivor) throws SQLException, PlayerIsDeadException {
        survivorDao.updateActionPoints(survivor.getId(),survivor.getMaxActionPoints());
        survivor.setHungerLevel(-35);
        survivorDao.updateHungerLevel(survivor.getId(),survivor.getHungerLevel());
        survivor.setRadiationLevel(-10);
        survivorDao.updateRadiationLevel(survivor.getId(),survivor.getRadiationLevel());
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


