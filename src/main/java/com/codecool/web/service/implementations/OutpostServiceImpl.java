package com.codecool.web.service.implementations;

import com.codecool.web.dao.OutpostDao;
import com.codecool.web.exception.ItemNotFoundException;
import com.codecool.web.exception.NoSuchOutpostException;
import com.codecool.web.model.items.*;
import com.codecool.web.model.locations.Outpost;
import com.codecool.web.service.OutpostService;

import java.sql.SQLException;
import java.util.List;

public class OutpostServiceImpl implements OutpostService {

    OutpostDao dao;

    public OutpostServiceImpl(OutpostDao dao) {
        this.dao = dao;
    }

    @Override
    public Food findFood(String name) throws ItemNotFoundException {
        return null;
    }

    @Override
    public Outpost findOutpostbyFractionName(String name) throws SQLException, NoSuchOutpostException {
        switch (name){
            case "Brotherhood of Steel":
                return dao.findOutpost("Lost Hills");
            case "Minuteman":
                return dao.findOutpost("Sniper's hideout");
            case "The Institute":
                return dao.findOutpost("The Institute");
            default:
                throw new NoSuchOutpostException();
        }
    }

    @Override
    public Weapon findWeapon(String name) throws ItemNotFoundException {
        return null;
    }

    @Override
    public Medicine findMedicine(String name) throws ItemNotFoundException {
        return null;
    }

    @Override
    public Resource findResource(String name) throws ItemNotFoundException {
        return null;
    }

    @Override
    public Weapon findCraftableWeapon(String name) throws ItemNotFoundException {
        return null;
    }

    @Override
    public Food findCraftableFood(String name) throws ItemNotFoundException {
        return null;
    }

    @Override
    public Medicine findCraftableMedicine(String name) throws ItemNotFoundException {
        return null;
    }

    @Override
    public Furniture findFurniture(String name) throws ItemNotFoundException {
        return null;
    }

    @Override
    public Furniture findBuildable(String name) throws ItemNotFoundException {
        return null;
    }

    @Override
    public void removeItem(String name) throws ItemNotFoundException {

    }

    @Override
    public boolean containsResource(List<String> resources) {
        return false;
    }

    @Override
    public boolean containsFurnitures(String furnitureName) {
        return false;
    }
}
