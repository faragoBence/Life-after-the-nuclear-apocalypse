package com.codecool.web.service;

import com.codecool.web.exception.ItemNotFoundException;
import com.codecool.web.exception.NoSuchOutpostException;
import com.codecool.web.model.items.*;
import com.codecool.web.model.locations.Outpost;

import java.sql.SQLException;
import java.util.List;

public interface OutpostService {

    Food findFood(String name) throws ItemNotFoundException;

    Outpost findOutpostbyFractionName(String name) throws SQLException, NoSuchOutpostException;

    Weapon findWeapon(String name) throws ItemNotFoundException;

    Medicine findMedicine(String name) throws ItemNotFoundException;

    Resource findResource(String name) throws ItemNotFoundException;

    Weapon findCraftableWeapon(String name) throws ItemNotFoundException;

    Food findCraftableFood(String name) throws ItemNotFoundException;

    Medicine findCraftableMedicine(String name) throws ItemNotFoundException;

    Furniture findFurniture(String name) throws ItemNotFoundException;

    Furniture findBuildable(String name) throws ItemNotFoundException;

    void removeItem(String name) throws ItemNotFoundException;

    boolean containsResource(List<String> resources);

    boolean containsFurnitures(String furnitureName);


}


